package com.rays.service;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.CollegeDAOInt;
import com.rays.dto.CollegeDTO;

/**
 * CollegeServiceImpl provides the implementation of CollegeServiceInt interface.
 * 
 * It extends BaseServiceImpl to provide standard CRUD operations for CollegeDTO.
 * 
 * This class handles business logic related to colleges and interacts
 * with the database through CollegeDAOInt.
 * 
 * Author: Akbar Mansuri
 */
@Service
public class CollegeServiceImpl extends BaseServiceImpl<CollegeDTO, CollegeDAOInt> implements CollegeServiceInt {

}