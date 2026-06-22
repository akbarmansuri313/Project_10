package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.CoworkingDTO;
import com.rays.form.CoworkingForm;
import com.rays.service.CowrokingServiceInt;

@RestController
@RequestMapping(value = "Coworking")
public class CoworkingCtl extends BaseCtl<CoworkingForm, CoworkingDTO, CowrokingServiceInt> {

}
