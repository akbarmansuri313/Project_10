package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.DroneDeliveryDTO;
import com.rays.form.DroneDeliveryForm;
import com.rays.service.DroneServiceInt;


@RestController
@RequestMapping(value = "Drone")
public class DroneCtl extends BaseCtl<DroneDeliveryForm, DroneDeliveryDTO, DroneServiceInt>{

}
