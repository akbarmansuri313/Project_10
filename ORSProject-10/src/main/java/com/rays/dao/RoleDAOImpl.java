
package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.RoleDTO;

/**
 * RoleDAOImpl is the implementation class for RoleDAOInt interface.
 * 
 * It extends BaseDAOImpl to provide basic CRUD operations and 
 * overrides specific methods to define custom behavior for RoleDTO.
 * 
 * This class is responsible for interacting with the database 
 * for Role-related operations using JPA Criteria API.
 * 
 * @author 
 */
@Repository
public class RoleDAOImpl extends BaseDAOImpl<RoleDTO> implements RoleDAOInt {

	/**
	 * Returns the class type of RoleDTO.
	 * 
	 * This method is used by the generic BaseDAOImpl class
	 * to identify the DTO class at runtime.
	 * 
	 * @return Class of RoleDTO
	 */
	@Override
	public Class<RoleDTO> getDTOClass() {
		return RoleDTO.class;
	}

	/**
	 * Builds dynamic where clause conditions based on the values
	 * present in the RoleDTO object.
	 * 
	 * This method uses CriteriaBuilder to create predicates
	 * for filtering data from the database.
	 * 
	 * @param dto     RoleDTO object containing search criteria
	 * @param builder CriteriaBuilder used to construct predicates
	 * @param qRoot   Root reference of RoleDTO entity
	 * @return List of Predicate conditions
	 */
	@Override
	protected List<Predicate> getWhereClause(RoleDTO dto, CriteriaBuilder builder, Root<RoleDTO> qRoot) {
		List<Predicate> whereCondition = new ArrayList<Predicate>();

//		if (!isZeroNumber(dto.getId())) {
//
//			whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
//		}

		if (!isEmptyString(dto.getName())) {
			whereCondition.add(builder.like(qRoot.get("name"), dto.getName() + "%"));
		}

		if (!isEmptyString(dto.getDescription())) {
			whereCondition.add(builder.like(qRoot.get("description"), dto.getDescription() + "%"));
		}

		return whereCondition;
	}
}