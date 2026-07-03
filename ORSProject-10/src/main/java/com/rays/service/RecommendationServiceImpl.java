package com.rays.service;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.RecommendationDAOInt;
import com.rays.dto.RecommendationDTO;

@Service
public class RecommendationServiceImpl extends BaseServiceImpl<RecommendationDTO, RecommendationDAOInt> implements RecommendationServiceInt{

}
