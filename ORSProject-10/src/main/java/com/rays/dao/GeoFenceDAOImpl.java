package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.GeoFenceDTO;


@Repository
public class GeoFenceDAOImpl extends BaseDAOImpl<GeoFenceDTO> implements GeoFenceDAOInt {

	@Override
	public Class<GeoFenceDTO> getDTOClass() {

		return GeoFenceDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(GeoFenceDTO dto, CriteriaBuilder builder, Root<GeoFenceDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();
		
		if (!isEmptyString(dto.getLocationName())) {
			
			whereCondition.add(builder.like(qRoot.get("locationName"), dto.getLocationName() + "%"));
			
		}
		
		
		if (!isEmptyString(dto.getGeoFenceCode())) {
			
			whereCondition.add(builder.like(qRoot.get("geoFenceCode"), dto.getGeoFenceCode() + "%"));
			
		}
		
		return whereCondition;
	}

}
