package com.rays.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.VechicleDTO;

@Repository
public class VechicleDAOImpl extends BaseDAOImpl<VechicleDTO> implements VechicleDAOInt{

	@Override
	public Class<VechicleDTO> getDTOClass() {

		return VechicleDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(VechicleDTO dto, CriteriaBuilder builder, Root<VechicleDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();
		
		if (!isEmptyString(dto.getModel())) {
			
			whereCondition.add(builder.like(qRoot.get("model"), dto.getModel() + "%"));
			
		}
		
		if (!isEmptyString(dto.getVechicleName())) {
			
			whereCondition.add(builder.like(qRoot.get("vechicleName"), dto.getVechicleName() + "%"));
			
		}
		return whereCondition;
	}

}
