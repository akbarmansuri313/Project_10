package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.CollegeDTO;
import com.rays.dto.StudentDTO;
import com.rays.form.StudentForm;
import com.rays.service.CollegeServiceInt;
import com.rays.service.StudentServiceInt;

/**
 * StudentCtl is a REST controller for managing student-related operations.
 * 
 * It provides endpoints to preload college dropdown lists for student management.
 * 
 * Author: Akbar Mansuri
 */
@RestController
@RequestMapping(value = "Student")
public class StudentCtl extends BaseCtl<StudentForm, StudentDTO, StudentServiceInt> {

	@Autowired
	CollegeServiceInt collegeService;

	/**
	 * Preload colleges for student management dropdowns.
	 * 
	 * @return ORSResponse containing collegeList
	 */
	@GetMapping("preload")
	public ORSResponse preload() {
		ORSResponse res = new ORSResponse(true);

		CollegeDTO dto = new CollegeDTO();
		List<DropdownList> collegeList = collegeService.search(dto, userContext);

		res.addResult("collegeList", collegeList);
		return res;
	}
}