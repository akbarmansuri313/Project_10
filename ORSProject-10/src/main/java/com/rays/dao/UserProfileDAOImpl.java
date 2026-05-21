package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.UserProfileDTO;

@Repository
public class UserProfileDAOImpl extends BaseDAOImpl<UserProfileDTO> implements UserProfileDAOInt{

	@Override
	public Class<UserProfileDTO> getDTOClass() {

		return UserProfileDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(UserProfileDTO dto, CriteriaBuilder builder, Root<UserProfileDTO> qRoot) {

		List<Predicate> whereCondition  = new ArrayList<Predicate>();
		
		if (!isEmptyString(dto.getProfileCode())) {
			
			whereCondition.add(builder.like(qRoot.get("profileCode"), dto.getProfileCode() + "%"));
			
		}
		
		if (!isEmptyString(dto.getUserName())) {
			
			whereCondition.add(builder.like(qRoot.get("userName"), dto.getUserName() + "%"));
			
		}
		
		return whereCondition;
	}

}
