package com.rays.service;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.VehicleRentalDAOInt;
import com.rays.dto.VehicleRentalDTO;


@Service
public class VehicleRentalServiceImpl extends BaseServiceImpl<VehicleRentalDTO, VehicleRentalDAOInt> implements VehicleRentalServiceInt{

}
