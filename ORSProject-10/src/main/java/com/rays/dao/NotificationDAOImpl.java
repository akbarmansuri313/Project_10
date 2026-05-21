package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.NotificationDTO;

@Repository
public class NotificationDAOImpl extends BaseDAOImpl<NotificationDTO> implements NotificationDAOInt{

	@Override
	public Class<NotificationDTO> getDTOClass() {
		
		return NotificationDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(NotificationDTO dto, CriteriaBuilder builder,
			Root<NotificationDTO> qRoot) {
		
		List<Predicate> whereCondition = new ArrayList<Predicate>();
		
		if(dto != null) {
			
			if (!isEmptyString(dto.getTitle())) {
				whereCondition.add(builder.like(qRoot.get("title"), dto.getTitle() + "%"));
				
			}
			
		}
		
		return whereCondition;
	}

}
