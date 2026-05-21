package com.rays.service;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.CourseDAOInt;
import com.rays.dto.CourseDTO;

/**
 * CourseServiceImpl provides the implementation of CourseServiceInt interface.
 * 
 * It extends BaseServiceImpl to provide standard CRUD operations for CourseDTO.
 * 
 * This class handles business logic related to courses and interacts
 * with the database through CourseDAOInt.
 * 
 * Author: Akbar Mansuri
 */
@Service
public class CourseServiceImpl extends BaseServiceImpl<CourseDTO, CourseDAOInt> implements CourseServiceInt {

}