package com.rays.service;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.StudentDAOInt;
import com.rays.dto.StudentDTO;

/**
 * StudentServiceImpl provides the implementation of StudentServiceInt interface.
 * 
 * It extends BaseServiceImpl to provide standard CRUD operations for StudentDTO.
 * 
 * This class handles business logic related to students and interacts
 * with the database through StudentDAOInt.
 * 
 * Author: Akbar Mansuri
 */
@Service
public class StudentServiceImpl extends BaseServiceImpl<StudentDTO, StudentDAOInt> implements StudentServiceInt {

}