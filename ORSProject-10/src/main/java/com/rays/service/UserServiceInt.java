package com.rays.service;

import com.rays.common.BaseServiceInt;
import com.rays.common.UserContext;
import com.rays.dto.UserDTO;

/**
 * UserServiceInt is an interface that defines business operations
 * for UserDTO objects.
 * 
 * It extends BaseServiceInt to inherit common service operations
 * such as create, update, delete, and search.
 * 
 * This interface adds user-specific operations like authentication,
 * registration, password management, and retrieval by login ID.
 * 
 * Author: Akbar Mansuri
 */
public interface UserServiceInt extends BaseServiceInt<UserDTO> {

	/**
	 * Finds a user by their login ID.
	 * 
	 * @param name        Login ID of the user
	 * @param userContext Context information about the logged-in user
	 * @return UserDTO object if found, otherwise null
	 */
	public UserDTO findByLoginId(String name, UserContext userContext);

	/**
	 * Registers a new user.
	 * 
	 * @param dto UserDTO containing user details
	 * @return UserDTO object of the registered user
	 */
	public UserDTO register(UserDTO dto);

	/**
	 * Authenticates a user with login ID and password.
	 * 
	 * @param loginId  Login ID of the user
	 * @param password Password of the user
	 * @return UserDTO if authentication is successful, otherwise null
	 */
	public UserDTO authenticate(String loginId, String password);

	/**
	 * Initiates the forgot password process for a user.
	 * 
	 * @param loginId Login ID of the user
	 * @return true if the process is successful, otherwise false
	 */
	public boolean forgotPassword(String loginId);

	/**
	 * Changes the password for a user.
	 * 
	 * @param loginId     Login ID of the user
	 * @param oldPassword Current password of the user
	 * @param newPassword New password to be set
	 * @param userContext Context information about the logged-in user
	 * @return Updated UserDTO object after password change
	 */
	public UserDTO changePassword(String loginId, String oldPassword, String newPassword, UserContext userContext);

}