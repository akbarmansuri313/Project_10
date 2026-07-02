package com.rays.service;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.DroneDAOInt;
import com.rays.dto.DroneDeliveryDTO;


@Service
public class DroneServiceImpl extends BaseServiceImpl<DroneDeliveryDTO, DroneDAOInt> implements DroneServiceInt {

}
