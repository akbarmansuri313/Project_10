package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.GeoFenceDTO;
import com.rays.form.GeoFenceForm;
import com.rays.service.GeoFenceServiceInt;

@RestController
@RequestMapping(value = "GeoFence")
public class GeoFenceCtl  extends BaseCtl<GeoFenceForm, GeoFenceDTO, GeoFenceServiceInt>{

}
