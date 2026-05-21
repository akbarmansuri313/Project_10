package com.rays.service;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.DepartmentDAOImpl;
import com.rays.dto.DepartmentDTO;

@Service
public class DepartmentServiceImpl extends BaseServiceImpl<DepartmentDTO, DepartmentDAOImpl> implements DepartmentServiceInt {

}
