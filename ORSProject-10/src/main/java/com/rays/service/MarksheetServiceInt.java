package com.rays.service;

import java.util.List;

import com.rays.common.BaseServiceInt;
import com.rays.common.UserContext;
import com.rays.dto.MarksheetDTO;

/**
 * MarksheetServiceInt is an interface that defines business operations
 * for MarksheetDTO objects.
 * 
 * It extends BaseServiceInt to inherit common service operations
 * such as create, update, delete, and search.
 * 
 * Additionally, it provides functionality for retrieving merit lists
 * and finding marksheets by roll number.
 * 
 * Author: Akbar Mansuri
 */
public interface MarksheetServiceInt extends BaseServiceInt<MarksheetDTO> {


	/**
	 * Finds a marksheet by its roll number.
	 * 
	 * @param rollNo  Roll number of the student
	 * @param context UserContext containing details of the user making the request
	 * @return MarksheetDTO if found, otherwise null
	 */
	public MarksheetDTO findByRollNo(String rollNo, UserContext context);
}