package com.rays.dao;

import com.rays.common.BaseDAOInt;
import com.rays.dto.UserDTO;

/**
 * Data Access Object interface for User.
 * Extends the generic BaseDAOInt to provide CRUD operations for UserDTO.
 */
public interface UserDAOInt extends BaseDAOInt<UserDTO> {
    // You can add User-specific DAO methods here, if needed.
}