package com.rays.service;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.PetAdoptionDAOInt;
import com.rays.dto.PetAdoptionDTO;

@Service
public class PetAdoptionServiceImpl extends BaseServiceImpl<PetAdoptionDTO, PetAdoptionDAOInt> implements PetAdoptionServiceInt{

}
