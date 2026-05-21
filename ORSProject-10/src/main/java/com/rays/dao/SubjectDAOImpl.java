package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.common.UserContext;
import com.rays.dto.CourseDTO;
import com.rays.dto.SubjectDTO;

/**
 * Implementation of {@link SubjectDAOInt} for managing SubjectDTO entities.
 * <p>
 * Provides CRUD operations and database interactions for subjects. It populates
 * related course information for each subject using {@link CourseDAOImpl}.
 * </p>
 */
@Repository
public class SubjectDAOImpl extends BaseDAOImpl<SubjectDTO> implements SubjectDAOInt {

	@Autowired
	CourseDAOImpl courseDAO;

	/**
	 * Returns the class type of the DTO managed by this DAO.
	 *
	 * @return SubjectDTO.class
	 */
	@Override
	public Class<SubjectDTO> getDTOClass() {
		return SubjectDTO.class;
	}

	/**
	 * Builds a list of predicates for querying the database. Currently returns an
	 * empty list.
	 *
	 * @param dto     The SubjectDTO containing search criteria.
	 * @param builder CriteriaBuilder for constructing predicates.
	 * @param qRoot   Root entity for the query.
	 * @return List of predicates (currently empty)
	 */
	@Override
	protected List<Predicate> getWhereClause(SubjectDTO dto, CriteriaBuilder builder, Root<SubjectDTO> qRoot) {
		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getCourseName())) {

			whereCondition.add(builder.like(qRoot.get("courseName"), dto.getCourseName() + "%"));

		}

		if (!isEmptyString(dto.getName())) {

			whereCondition.add(builder.like(qRoot.get("name"), dto.getName() + "%"));

		}
		return whereCondition;
	}

	/**
	 * Populates additional information for the SubjectDTO.
	 * <p>
	 * Specifically, sets the course name by fetching it from the related course
	 * entity.
	 * </p>
	 *
	 * @param dto         The SubjectDTO to populate
	 * @param userContext The context of the current user
	 */
	@Override
	protected void populate(SubjectDTO dto, UserContext userContext) {
		CourseDTO dto1 = courseDAO.findByPK(dto.getCourseId(), userContext);
		dto.setCourseName(dto1.getName());
	}

}