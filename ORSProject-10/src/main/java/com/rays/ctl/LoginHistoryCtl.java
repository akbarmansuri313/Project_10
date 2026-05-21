package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.LoginHistoryDTO;
import com.rays.form.LoginHistoryForm;
import com.rays.service.LoginHistoryServiceInt;

@RestController
@RequestMapping(value = "Login")
public class LoginHistoryCtl extends BaseCtl<LoginHistoryForm, LoginHistoryDTO, LoginHistoryServiceInt> {

}
