package com.rays.dao;

import java.util.List;

import com.rays.common.BaseDAOInt;
import com.rays.dto.MarksheetDTO;

/**
 * MarksheetDAOInt is an interface that defines data access operations
 * for MarksheetDTO objects.
 * 
 * It extends BaseDAOInt to inherit common CRUD operations.
 * 
 * Additionally, it provides a method to retrieve the merit list
 * of marksheets based on certain criteria (e.g., highest marks).
 * 
 * This interface should be implemented by classes handling
 * database operations related to marksheets.
 * 
 * @author 
 */
public interface MarksheetDAOInt extends BaseDAOInt<MarksheetDTO> {
	
	
}