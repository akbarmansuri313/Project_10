package com.rays.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rays.dto.UserDTO;

/**
 * JWTUserDetailsService implements Spring Security's UserDetailsService.
 * 
 * This class is responsible for loading user-specific data during
 * authentication in a JWT-based security setup.
 * 
 * It fetches user details from the UserService and encodes passwords
 * using BCryptPasswordEncoder.
 * 
 * Author: Akbar Mansuri
 */
@Service
public class JWTUserDetailsService implements UserDetailsService {

	/**
	 * Returns a BCryptPasswordEncoder bean for password encoding.
	 * 
	 * @return PasswordEncoder instance
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	UserServiceInt userService;

	/**
	 * Loads a user by username (loginId) for authentication.
	 * 
	 * @param username Login ID of the user
	 * @return UserDetails object used by Spring Security
	 * @throws UsernameNotFoundException if user is not found
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserDTO user = userService.findByLoginId(username, null);

		if (user == null) {
			throw new UsernameNotFoundException("User not found with username : " + username);
		}

		return User.builder()
				.username(user.getLoginId())
				.password(passwordEncoder().encode(user.getPassword()))
				.roles("USER")
				.build();
	}
}