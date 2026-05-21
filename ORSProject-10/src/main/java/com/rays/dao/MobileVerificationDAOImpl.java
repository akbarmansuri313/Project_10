package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.MobileVerificationDTO;


@Repository
public class MobileVerificationDAOImpl extends BaseDAOImpl<MobileVerificationDTO> implements MobileVerificationDAOInt {

	@Override
	public Class<MobileVerificationDTO> getDTOClass() {

		return MobileVerificationDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(MobileVerificationDTO dto, CriteriaBuilder builder,
			Root<MobileVerificationDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();
		
		if (!isEmptyString(dto.getVerificationCode())) {
			
			whereCondition.add(builder.like(qRoot.get("verificationCode"), dto.getVerificationCode() + "%"));
			
		}
		
		if (!isEmptyString(dto.getMobileNumber())) {
			
			whereCondition.add(builder.like(qRoot.get("mobileNumber"), dto.getMobileNumber() + "%"));
			
		}
		
		if (!isEmptyString(dto.getStatus())) {
			
			whereCondition.add(builder.like(qRoot.get("status"), dto.getStatus() + "%"));
			
		}
		
		return whereCondition;
	}

}
