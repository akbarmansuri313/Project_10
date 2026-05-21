package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.CourseDTO;

/**
 * CourseDAOImpl is the implementation class for CourseDAOInt interface.
 * 
 * It extends BaseDAOImpl to provide basic CRUD operations for CourseDTO.
 * 
 * This class is responsible for handling database interactions
 * related to course entities and supports dynamic query creation
 * using JPA Criteria API.
 * 
 * @author Akbar Mansuri
 */
@Repository
public class CourseDAOImpl extends BaseDAOImpl<CourseDTO> implements CourseDAOInt{

	/**
	 * Returns the class type of CourseDTO.
	 * 
	 * @return Class of CourseDTO
	 */
	@Override
	public Class<CourseDTO> getDTOClass() {
		return CourseDTO.class;
	}

	/**
	 * Builds dynamic where clause conditions based on CourseDTO fields.
	 * 
	 * Currently, no filtering conditions are applied.
	 * This method can be extended in future to add search criteria.
	 * 
	 * @param dto     CourseDTO containing search criteria
	 * @param builder CriteriaBuilder for creating predicates
	 * @param qRoot   Root reference of CourseDTO entity
	 * @return List of Predicate conditions
	 */
	@Override
	protected List<Predicate> getWhereClause(CourseDTO dto, CriteriaBuilder builder, Root<CourseDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();
		
		
		if (!isEmptyString(dto.getName())) {
			
			whereCondition.add(builder.like(qRoot.get("name"), dto.getName() + "%"));
			
		}
		
		if (!isEmptyString(dto.getDuration())) {
			
			whereCondition.add(builder.like(qRoot.get("duration"), dto.getDuration() + "%"));
			
		}
		return whereCondition;
	}

}