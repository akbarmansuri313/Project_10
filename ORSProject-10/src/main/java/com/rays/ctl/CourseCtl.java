package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.CourseDTO;
import com.rays.form.CourseForm;
import com.rays.service.CourseServiceInt;

/**
 * CourseCtl handles REST requests related to Course.
 * 
 * @author Akbar Mansuri
 */
@RestController
@RequestMapping("Course")
public class CourseCtl extends BaseCtl<CourseForm, CourseDTO, CourseServiceInt> {

}