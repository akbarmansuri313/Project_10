package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.RecommendationDTO;

@Repository
public class RecommendationDAOImpl extends BaseDAOImpl<RecommendationDTO> implements RecommendationDAOInt{

	@Override
	public Class<RecommendationDTO> getDTOClass() {

		return RecommendationDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(RecommendationDTO dto, CriteriaBuilder builder,
			Root<RecommendationDTO> qRoot) {

		
		List<Predicate> whereCondition = new ArrayList<Predicate>();
		
		if (!isEmptyString(dto.getRecommendationCode())) {
			
			whereCondition.add(builder.like(qRoot.get("recommendationCode"), dto.getRecommendationCode() + "%"));
			
		}
		
		if (!isEmptyString(dto.getUserName())) {
			
			whereCondition.add(builder.like(qRoot.get("userName"), dto.getUserName() + "%"));
			
		}
		
		return whereCondition;
	}

}
