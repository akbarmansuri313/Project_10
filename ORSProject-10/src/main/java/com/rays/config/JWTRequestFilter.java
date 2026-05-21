package com.rays.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import com.rays.common.UserContext;
import com.rays.common.UserContextHolder;
import com.rays.dto.UserDTO;
import com.rays.service.JWTUserDetailsService;

/**
 * JWTRequestFilter is a Spring Security filter that intercepts each HTTP request
 * to validate JWT tokens and set the security context.
 * 
 * It extracts the JWT token from the Authorization header, validates it, 
 * sets the authenticated user in Spring Security's context, and also 
 * stores the UserContext in a ThreadLocal for application use.
 * 
 * Author: Akbar Mansuri
 */
@Component
public class JWTRequestFilter extends OncePerRequestFilter {

	@Autowired
	private JWTUtil jwtUtil;

	@Autowired
	private JWTUserDetailsService jwtUserDetailsService;
	
	
	@Autowired
	@Qualifier("handlerExceptionResolver")
	private HandlerExceptionResolver resolver;

	/**
	 * Intercepts each HTTP request to check for a valid JWT token.
	 * 
	 * @param request     HttpServletRequest object
	 * @param response    HttpServletResponse object
	 * @param filterChain FilterChain object to pass the request along
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		final String authorizationHeader = request.getHeader("Authorization");

		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {

			String jwtToken = authorizationHeader.substring(7);

			try {
				String loginId = jwtUtil.extractLoginId(jwtToken);

				if (!jwtUtil.validateToken(jwtToken, loginId)) {
					throw new Exception("Invalid JWT token");
				}

				if (loginId != null && SecurityContextHolder.getContext().getAuthentication() == null) {

					UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(loginId);

					UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
							userDetails, null, userDetails.getAuthorities());

					authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

					SecurityContextHolder.getContext().setAuthentication(authenticationToken);
				}

				// Set UserContext for application
				UserDTO dto = new UserDTO();
				
				dto.setLoginId(loginId);

				UserContext context = new UserContext(dto);
				
				UserContextHolder.setContext(context);

			} catch (Exception e) {
				
//				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//				
//				response.getWriter().write(e.getMessage());
				
				resolver.resolveException(request, response, null, e);
				
				return;
			}
		}
		filterChain.doFilter(request, response);
	}
}