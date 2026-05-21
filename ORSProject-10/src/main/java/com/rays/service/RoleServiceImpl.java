package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.rays.common.BaseServiceImpl;
import com.rays.common.UserContext;
import com.rays.dao.RoleDAOInt;
import com.rays.dto.RoleDTO;

/**
 * RoleServiceImpl provides the implementation of RoleServiceInt interface.
 * 
 * It extends BaseServiceImpl to provide standard CRUD operations for RoleDTO.
 * 
 * This class handles business logic related to roles and interacts
 * with the database through RoleDAOInt.
 * 
 * Transactions are managed using Spring's @Transactional annotation.
 * 
 * Author: Akbar Mansuri
 */
@Service
@Transactional
public class RoleServiceImpl extends BaseServiceImpl<RoleDTO, RoleDAOInt> implements RoleServiceInt {

	/**
	 * Finds a role by its name.
	 * 
	 * @param name        Name of the role
	 * @param userContext Context information of the user performing the operation
	 * @return RoleDTO if found, otherwise null
	 */
	@Override
	@Transactional(readOnly = true)
	public RoleDTO findByName(String name, UserContext userContext) {
		return baseDao.findByUniqueKey("name", name, userContext);
	}
	
}