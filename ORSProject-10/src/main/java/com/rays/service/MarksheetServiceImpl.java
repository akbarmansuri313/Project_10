package com.rays.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.common.UserContext;
import com.rays.dao.MarksheetDAOInt;
import com.rays.dto.MarksheetDTO;

/**
 * MarksheetServiceImpl provides the implementation of MarksheetServiceInt interface.
 * 
 * It extends BaseServiceImpl to provide standard CRUD operations for MarksheetDTO.
 * 
 * This class handles business logic related to marksheets, including
 * retrieving merit lists and finding marksheets by roll number.
 * 
 * Author: Akbar Mansuri
 */
@Service
public class MarksheetServiceImpl extends BaseServiceImpl<MarksheetDTO, MarksheetDAOInt> implements MarksheetServiceInt {



	/**
	 * Finds a marksheet by its roll number.
	 * 
	 * @param rollNo  Roll number of the student
	 * @param context UserContext containing details of the user making the request
	 * @return MarksheetDTO if found, otherwise null
	 */
	@Override
	public MarksheetDTO findByRollNo(String rollNo, UserContext context) {
		return baseDao.findByUniqueKey("rollNo", rollNo, context);
	}

}