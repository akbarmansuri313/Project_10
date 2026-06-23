package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.PetAdoptionDTO;

@Repository
public class PetAdoptionDAOImpl extends BaseDAOImpl<PetAdoptionDTO> implements PetAdoptionDAOInt{

	@Override
	public Class<PetAdoptionDTO> getDTOClass() {

		return PetAdoptionDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(PetAdoptionDTO dto, CriteriaBuilder builder, Root<PetAdoptionDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();
		
		if (!isEmptyString(dto.getPetName())) {
			whereCondition.add(builder.like(qRoot.get("petName"), dto.getPetName() + "%"));
		}
		
		if (!isEmptyString(dto.getBreed())) {
			whereCondition.add(builder.like(qRoot.get("breed"), dto.getBreed() + "%"));
			
		}
		
		return whereCondition;
	}

}
