package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.CloudStorageDTO;
import com.rays.form.CloudStorageForm;
import com.rays.service.CloudStorageServiceInt;

@RestController
@RequestMapping(value = "Cloud")
public class CloudStorageCtl extends BaseCtl<CloudStorageForm, CloudStorageDTO, CloudStorageServiceInt>{

}
