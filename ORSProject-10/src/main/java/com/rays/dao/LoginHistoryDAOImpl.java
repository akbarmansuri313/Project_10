package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.LoginHistoryDTO;


@Repository
public class LoginHistoryDAOImpl extends BaseDAOImpl<LoginHistoryDTO> implements LoginHistoryDAOInt{

	@Override
	public Class<LoginHistoryDTO> getDTOClass() {

		return LoginHistoryDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(LoginHistoryDTO dto, CriteriaBuilder builder,
			Root<LoginHistoryDTO> qRoot) {

		
		List<Predicate> whereCondition = new ArrayList<Predicate>();
		
		
		if (!isEmptyString(dto.getHistoryCode())) {
			
			whereCondition.add(builder.like(qRoot.get("historyCode"), dto.getHistoryCode() + "%"));
			
		}
		
		if (!isEmptyString(dto.getUserName())) {
			
			whereCondition.add(builder.like(qRoot.get("userName"), dto.getUserName() + "%"));
		}
		
		return whereCondition;
	}

}
