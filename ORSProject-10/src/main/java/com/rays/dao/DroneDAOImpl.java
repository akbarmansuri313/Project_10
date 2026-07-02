package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.common.UserContext;
import com.rays.dto.DroneDeliveryDTO;


@Repository
public class DroneDAOImpl extends BaseDAOImpl<DroneDeliveryDTO> implements DroneDAOInt{

	@Override
	public Class<DroneDeliveryDTO> getDTOClass() {

		return DroneDeliveryDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(DroneDeliveryDTO dto, CriteriaBuilder builder,
			Root<DroneDeliveryDTO> qRoot) {

	List<Predicate> whereCondition = new ArrayList<Predicate>();
	
	
	if (!isEmptyString(dto.getDroneCode())) {
		
		whereCondition.add(builder.like(qRoot.get("droneCode"), dto.getDroneCode() + "%"));
		
	}
	
	if (!isEmptyString(dto.getOperatorName())) {
		
		whereCondition.add(builder.like(qRoot.get("operatorName"), dto.getOperatorName() + "%"));
		
	}
	
		return whereCondition;
	}

	
}
