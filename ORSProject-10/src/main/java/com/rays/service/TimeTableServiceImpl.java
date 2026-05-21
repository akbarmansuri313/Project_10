package com.rays.service;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.TimeTableDAOInt;
import com.rays.dto.TimeTableDTO;

/**
 * TimeTableServiceImpl provides the implementation of TimeTableServiceInt interface.
 * 
 * It extends BaseServiceImpl to provide standard CRUD operations for TimeTableDTO.
 * 
 * This class handles business logic related to timetable management and interacts
 * with the database through TimeTableDAOInt.
 * 
 * Author: Akbar Mansuri
 */
@Service
public class TimeTableServiceImpl extends BaseServiceImpl<TimeTableDTO, TimeTableDAOInt>
		implements TimeTableServiceInt {

}