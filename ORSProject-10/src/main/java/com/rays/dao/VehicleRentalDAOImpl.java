package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.VehicleRentalDTO;

@Repository
public class VehicleRentalDAOImpl extends BaseDAOImpl<VehicleRentalDTO> implements VehicleRentalDAOInt{

	@Override
	public Class<VehicleRentalDTO> getDTOClass() {

		return VehicleRentalDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(VehicleRentalDTO dto, CriteriaBuilder builder,
			Root<VehicleRentalDTO> qRoot) {

		
		List<Predicate> whereCondition  = new ArrayList<Predicate>();
		
		if (!isEmptyString(dto.getCustomerName())) {
			
			whereCondition.add(builder.like(qRoot.get("customerName"), dto.getCustomerName() + "%"));
			
		}
		
		return whereCondition;
	}

}
