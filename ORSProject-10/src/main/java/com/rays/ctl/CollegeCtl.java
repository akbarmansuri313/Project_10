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
import com.rays.form.CollegeForm;
import com.rays.service.CollegeServiceInt;

/**
 * CollegeCtl handles REST requests related to College.
 * 
 * @author Akbar Mansuri
 */
@RestController
@RequestMapping("College")
public class CollegeCtl extends BaseCtl<CollegeForm, CollegeDTO, CollegeServiceInt> {
	
	@Autowired
	private CollegeServiceInt collegeServiceInt;
	
	
	
	@GetMapping("preload")
	
	public ORSResponse preload() {
		
		ORSResponse res = new ORSResponse(true);
		
		CollegeDTO dto = new CollegeDTO();
		
		List<DropdownList> collegeList = collegeServiceInt.search(dto, userContext);
		
		res.addResult("collegeList", collegeList);
		
		return res;
		
	}
	
	
	
	
	

}