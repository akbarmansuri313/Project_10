package com.rays.dao;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOInt;
import com.rays.dto.FacultyDTO;

/**
 * FacultyDAOInt is an interface that defines data access operations
 * for FacultyDTO objects.
 * 
 * It extends BaseDAOInt to inherit common CRUD operations such as
 * create, update, delete, and search.
 * 
 * This interface should be implemented by classes that handle
 * database interactions related to faculty records.
 * 
 * @author Akbar Mansuri
 */
@Repository
public interface FacultyDAOInt extends BaseDAOInt<FacultyDTO> {

}