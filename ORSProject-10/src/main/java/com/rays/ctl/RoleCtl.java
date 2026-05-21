package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.RoleDTO;
import com.rays.form.RoleForm;
import com.rays.service.RoleServiceInt;

/**
 * RoleCtl is a REST controller for managing role-related operations.
 * 
 * It provides standard CRUD operations through BaseCtl for RoleDTO.
 * 
 * Author: Akbar Mansuri
 */
@RestController
@RequestMapping(value = "Role")
public class RoleCtl extends BaseCtl<RoleForm, RoleDTO, RoleServiceInt> {
	
	
	
	
	
}