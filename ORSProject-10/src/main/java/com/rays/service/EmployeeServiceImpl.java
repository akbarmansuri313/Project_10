package com.rays.service;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.EmployeeDAOInt;
import com.rays.dto.EmployeeDTO;


@Service
public class EmployeeServiceImpl extends BaseServiceImpl<EmployeeDTO, EmployeeDAOInt> implements EmployeeServiceInt{

}
