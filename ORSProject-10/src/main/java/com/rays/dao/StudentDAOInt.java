package com.rays.dao;

import com.rays.common.BaseDAOInt;
import com.rays.dto.StudentDTO;

/**
 * Data Access Object interface for {@link StudentDTO} entities.
 * <p>
 * Provides basic CRUD operations and database interactions
 * for managing student data. Extends {@link BaseDAOInt} to inherit
 * common DAO methods.
 * </p>
 */
public interface StudentDAOInt extends BaseDAOInt<StudentDTO> {

}