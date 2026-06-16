package com.rays.service;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.VechicleDAOInt;
import com.rays.dto.VechicleDTO;

@Service
public class VechicleServiceImpl extends BaseServiceImpl<VechicleDTO, VechicleDAOInt> implements VechicleServiceInt{

}
