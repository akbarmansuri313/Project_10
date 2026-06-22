package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.CoworkingDTO;

@Repository
public class CoworkingDAOImpl extends  BaseDAOImpl<CoworkingDTO> implements CoworkingDAOInt{

	@Override
	public Class<CoworkingDTO> getDTOClass() {

		return CoworkingDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(CoworkingDTO dto, CriteriaBuilder builder, Root<CoworkingDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();
		
		if (!isEmptyString(dto.getSpaceName())) {
			
			whereCondition.add(builder.like(qRoot.get("spaceName"), dto.getSpaceName() + "%"));
			
		}
		
		return whereCondition;
	}

}
