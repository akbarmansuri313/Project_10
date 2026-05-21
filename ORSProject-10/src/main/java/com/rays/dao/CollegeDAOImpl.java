package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import com.rays.common.BaseDAOImpl;
import com.rays.dto.CollegeDTO;

/**
 * CollegeDAOImpl is the implementation class for CollegeDAOInt interface.
 * 
 * It extends BaseDAOImpl to provide basic CRUD operations for CollegeDTO.
 * 
 * This class handles database interactions related to college entities and
 * supports dynamic query building using JPA Criteria API.
 * 
 * It allows filtering based on college name and address.
 * 
 * @author Akbar Mansuri
 */
@Repository
public class CollegeDAOImpl extends BaseDAOImpl<CollegeDTO> implements CollegeDAOInt {

	/**
	 * Returns the class type of CollegeDTO.
	 * 
	 * @return Class of CollegeDTO
	 */
	@Override
	public Class<CollegeDTO> getDTOClass() {
		return CollegeDTO.class;
	}

	/**
	 * Builds dynamic where clause conditions based on CollegeDTO fields.
	 * 
	 * Filters records using name and address if provided.
	 * 
	 * @param dto     CollegeDTO containing search criteria
	 * @param builder CriteriaBuilder for creating predicates
	 * @param qRoot   Root reference of CollegeDTO entity
	 * @return List of Predicate conditions
	 */
	@Override
	protected List<Predicate> getWhereClause(CollegeDTO dto, CriteriaBuilder builder, Root<CollegeDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isZeroNumber(dto.getId())) {

			whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));

		}
		
		

		if (!isEmptyString(dto.getCity())) {
			whereCondition.add(builder.like(qRoot.get("city"), dto.getCity() + "%"));
		}
		return whereCondition;
	}

}