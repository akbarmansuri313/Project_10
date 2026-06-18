package com.rays.service;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.FoodOrderDAOImpl;
import com.rays.dto.FoodOrderDTO;

@Service
public class FoodOrderServiceImpl extends BaseServiceImpl<FoodOrderDTO, FoodOrderDAOImpl> implements FoodOrderServiceInt{

}
