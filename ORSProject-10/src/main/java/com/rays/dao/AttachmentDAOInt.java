package com.rays.dao;

import com.rays.common.BaseDAOInt;
import com.rays.dto.AttachmentDTO;

/**
 * AttachmentDAOInt is a Data Access Object (DAO) interface
 * for performing database operations on AttachmentDTO.
 * 
 * It extends BaseDAOInt to inherit standard CRUD operations
 * like add, update, delete, findByPK, search, etc.
 * 
 * This interface can be extended with custom database
 * queries specific to attachments if required.
 * 

 * 
 * @author Akbar Mansuri
 */
public interface AttachmentDAOInt extends BaseDAOInt<AttachmentDTO>{

}