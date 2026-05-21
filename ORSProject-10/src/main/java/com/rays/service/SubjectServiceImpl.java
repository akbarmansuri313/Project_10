package com.rays.service;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.SubjectDAOImpl;
import com.rays.dto.SubjectDTO;

/**
 * SubjectServiceImpl provides the implementation of SubjectServiceInt interface.
 * 
 * It extends BaseServiceImpl to provide standard CRUD operations for SubjectDTO.
 * 
 * This class handles business logic related to subjects and interacts
 * with the database through SubjectDAOImpl.
 * 
 * Author: Akbar Mansuri
 */
@Service
public class SubjectServiceImpl extends BaseServiceImpl<SubjectDTO, SubjectDAOImpl> implements SubjectServiceInt {

}