package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.DepartmentDTO;
import com.rays.form.DepartmentForm;
import com.rays.service.DepartmentServiceInt;

/**
 * DepartmentCtl handles REST requests related to Department.
 * 
 * @author Akbar Mansuri
 */
@RestController
@RequestMapping("Department")
public class DepartmentCtl extends BaseCtl<DepartmentForm, DepartmentDTO, DepartmentServiceInt> {

}