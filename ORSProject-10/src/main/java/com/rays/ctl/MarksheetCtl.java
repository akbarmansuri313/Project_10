package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.MarksheetDTO;
import com.rays.dto.StudentDTO;
import com.rays.form.MarksheetForm;
import com.rays.service.MarksheetServiceInt;
import com.rays.service.StudentServiceInt;

/**
 * MarksheetCtl is a REST controller for managing marksheet-related operations.
 * 
 * It provides endpoints to preload student lists, retrieve merit lists, and fetch
 * marksheet details by roll number.
 * 
 * Author: Akbar Mansuri
 */
@RestController
@RequestMapping(value = "Marksheet")
public class MarksheetCtl extends BaseCtl<MarksheetForm, MarksheetDTO, MarksheetServiceInt> {

	@Autowired
	private StudentServiceInt studentService;

	/**
	 * Preload students for marksheet operations.
	 * 
	 * @return ORSResponse containing studentList
	 */
	@GetMapping("preload")
	public ORSResponse preload() {
		
		ORSResponse res = new ORSResponse(true);

		StudentDTO dto = new StudentDTO();
		
		List<StudentDTO> studentList = studentService.search(dto, userContext);

		res.addResult("studentList", studentList);
		return res;
	}

	/**
	 * Retrieve marksheet by roll number.
	 * 
	 * @param rollNo The roll number of the student
	 * @return ORSResponse containing the marksheet or error message
	 */
	@GetMapping("rollno/{rollNo}")
	public ORSResponse rollNo(@PathVariable String rollNo) {
		ORSResponse res = new ORSResponse(true);

		MarksheetDTO dto = baseService.findByRollNo(rollNo, userContext);
		if (dto != null) {
			res.addData(dto);
		} else {
			res.setSuccess(false);
			res.addMessage("Record not found");
		}

		return res;
	}

}