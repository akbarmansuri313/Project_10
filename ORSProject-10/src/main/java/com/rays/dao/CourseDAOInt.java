package com.rays.dao;

import com.rays.common.BaseDAOInt;
import com.rays.dto.CourseDTO;

/**
 * CourseDAOInt is an interface that defines data access operations
 * for CourseDTO objects.
 * 
 * It extends BaseDAOInt to inherit common CRUD operations such as
 * create, update, delete, and search.
 * 
 * This interface should be implemented by classes that handle
 * database interactions related to course records.
 * 
 * @author Akbar Mansuri
 */
public interface CourseDAOInt extends BaseDAOInt<CourseDTO> {

}