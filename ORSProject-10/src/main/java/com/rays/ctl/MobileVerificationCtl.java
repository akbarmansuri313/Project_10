package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.MobileVerificationDTO;
import com.rays.form.MobileVerificationForm;
import com.rays.service.MobileVerificationServiceInt;


@RestController
@RequestMapping(value = "Mobile")
public class MobileVerificationCtl extends BaseCtl<MobileVerificationForm, MobileVerificationDTO, MobileVerificationServiceInt>{

}
