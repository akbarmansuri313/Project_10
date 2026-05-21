package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.CloudStorageDTO;

@Repository
public class CloudStorageDAOImpl extends BaseDAOImpl<CloudStorageDTO> implements CloudStorageDAOInt {

	@Override
	public Class<CloudStorageDTO> getDTOClass() {

		return CloudStorageDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(CloudStorageDTO dto, CriteriaBuilder builder,
			Root<CloudStorageDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getUserName())) {

			whereCondition.add(builder.like(qRoot.get("userName"), dto.getUserName() + "%"));

		}
		
		if (!isEmptyString(dto.getFileName())) {
			
			whereCondition.add(builder.like(qRoot.get("fileName"), dto.getFileName() + "%"));
			
		}

		return whereCondition;
	}

}
