package com.rays.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * WebSecurityConfig configures Spring Security for the application.
 * 
 * It enables JWT-based stateless authentication and sets up request
 * authorization rules.
 * 
 * Key features: - Disables CSRF (since JWT is used) - Permits public access to
 * authentication endpoints and profile picture URLs - Requires authentication
 * for all other endpoints - Adds JWTRequestFilter before
 * UsernamePasswordAuthenticationFilter - Configures stateless session
 * management
 * 
 * Author: Akbar Mansuri
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JWTRequestFilter jwtRequestFilter;

	/**
	 * Configures HTTP security, request authorization, and JWT filter.
	 * 
	 * @param http HttpSecurity object
	 * @throws Exception in case of configuration errors
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/Auth/**", "/User/profilePic/**").permitAll()
				.anyRequest().authenticated().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		
		http.cors();
	}
}