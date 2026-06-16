package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.VehicleRentalDTO;
import com.rays.form.VehicleRentalForm;
import com.rays.service.VehicleRentalServiceInt;


@RestController
@RequestMapping(value = "Vehicle")
public class VehicleRentalCtl extends BaseCtl<VehicleRentalForm, VehicleRentalDTO, VehicleRentalServiceInt>{

}
