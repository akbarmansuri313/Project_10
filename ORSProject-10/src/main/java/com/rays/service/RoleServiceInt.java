package com.rays.service;

import com.rays.common.BaseServiceInt;
import com.rays.common.UserContext;
import com.rays.dto.RoleDTO;

/**
 * RoleServiceInt is an interface that defines business operations
 * for RoleDTO objects.
 * 
 * It extends BaseServiceInt to inherit common service operations
 * such as create, update, delete, and search.
 * 
 * Additionally, it provides functionality to find a role by its name.
 * 
 * This interface should be implemented by classes that handle
 * business logic related to roles.
 * 
 * Author: Akbar Mansuri
 */
public interface RoleServiceInt extends BaseServiceInt<RoleDTO> {
	
	/**
	 * Finds a role by its name.
	 * 
	 * @param name        Name of the role
	 * @param userContext Context information of the user performing the operation
	 * @return RoleDTO if found, otherwise null
	 */
	public RoleDTO findByName(String name, UserContext userContext);

}