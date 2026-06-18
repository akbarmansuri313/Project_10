package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.FoodOrderDTO;

@Repository
public class FoodOrderDAOImpl extends BaseDAOImpl<FoodOrderDTO> implements FoodOrderDAOInt{

	@Override
	public Class<FoodOrderDTO> getDTOClass() {

		return FoodOrderDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(FoodOrderDTO dto, CriteriaBuilder builder, Root<FoodOrderDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();
		
		
		if (!isEmptyString(dto.getCustomerName())) {
			
			whereCondition.add(builder.like(qRoot.get("customerName"), dto.getCustomerName() + "%"));
			
		}
		

		if (!isEmptyString(dto.getFoodItem())) {
			
			whereCondition.add(builder.like(qRoot.get("foodItem"), dto.getFoodItem() + "%"));
			
		}
		return whereCondition;
	}

}
