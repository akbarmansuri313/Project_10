package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.UserProfileDTO;
import com.rays.form.UserProfileForm;
import com.rays.service.UserProfileServiceInt;

@RestController
@RequestMapping(value = "Profile")
public class UserProfileCtl extends BaseCtl<UserProfileForm, UserProfileDTO, UserProfileServiceInt>{

}
