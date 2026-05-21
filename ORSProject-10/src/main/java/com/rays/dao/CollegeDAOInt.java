package com.rays.dao;

import com.rays.common.BaseDAOInt;
import com.rays.dto.CollegeDTO;

/**
 * CollegeDAOInt is an interface that defines data access operations
 * for CollegeDTO objects.
 * 
 * It extends BaseDAOInt to inherit common CRUD operations such as
 * create, update, delete, and search.
 * 
 * This interface should be implemented by classes that handle
 * database interactions related to college records.
 * 
 * @author Akbar Mansuri
 */
public interface CollegeDAOInt extends BaseDAOInt<CollegeDTO> {

}