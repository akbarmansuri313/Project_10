package com.rays.service;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.FacultyDAOInt;
import com.rays.dto.FacultyDTO;

/**
 * FacultyServiceImpl provides the implementation of FacultyServiceInt interface.
 * 
 * It extends BaseServiceImpl to provide standard CRUD operations for FacultyDTO.
 * 
 * This class handles business logic related to faculty members and interacts
 * with the database through FacultyDAOInt.
 * 
 * Author: Akbar Mansuri
 */
@Service
public class FacultyServiceImpl extends BaseServiceImpl<FacultyDTO, FacultyDAOInt> implements FacultyServiceInt {

}