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
import com.rays.dto.CourseDTO;
import com.rays.dto.FacultyDTO;
import com.rays.dto.SubjectDTO;
import com.rays.form.FacultyForm;
import com.rays.service.CollegeServiceInt;
import com.rays.service.CourseServiceInt;
import com.rays.service.FacultyServiceInt;
import com.rays.service.SubjectServiceInt;

/**
 * FacultyCtl handles REST requests related to Faculty.
 * Includes preload data for dropdowns: College, Course, Subject.
 * 
 * @author Akbar Mansuri
 */
@RestController
@RequestMapping("Faculty")
public class FacultyCtl extends BaseCtl<FacultyForm, FacultyDTO, FacultyServiceInt> {

    @Autowired
    private CollegeServiceInt collegeService;

    @Autowired
    private CourseServiceInt courseService;

    @Autowired
    private SubjectServiceInt subjectService;

    @GetMapping("preload")
    
    public ORSResponse preload() {

        ORSResponse res = new ORSResponse(true);

        List<DropdownList> collegeList = collegeService.search(new CollegeDTO(), userContext);
        
        List<DropdownList> courseList = courseService.search(new CourseDTO(), userContext);
        
        List<DropdownList> subjectList = subjectService.search(new SubjectDTO(), userContext);

        res.addResult("collegeList", collegeList);
        
        res.addResult("courseList", courseList);
        
        res.addResult("subjectList", subjectList);

        return res;
    }
}