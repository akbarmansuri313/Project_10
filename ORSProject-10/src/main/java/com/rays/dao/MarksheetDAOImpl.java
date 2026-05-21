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
import com.rays.dto.MarksheetDTO;
import com.rays.dto.StudentDTO;

/**
 * MarksheetDAOImpl is the implementation class for MarksheetDAOInt interface.
 * 
 * It extends BaseDAOImpl to provide basic CRUD operations and
 * implements additional functionalities specific to MarksheetDTO.
 * 
 * This class handles database interactions related to marksheets,
 * including dynamic query building and merit list generation.
 * 
 * @author Akbar Mansuri
 */
@Repository
public class MarksheetDAOImpl extends BaseDAOImpl<MarksheetDTO> implements MarksheetDAOInt {

	@Autowired
	StudentDAOImpl studentDao;

	/**
	 * Returns the class type of MarksheetDTO.
	 * 
	 * @return Class of MarksheetDTO
	 */
	@Override
	public Class<MarksheetDTO> getDTOClass() {
		return MarksheetDTO.class;
	}

	/**
	 * Populates additional fields in MarksheetDTO before saving or updating.
	 * 
	 * It fetches StudentDTO using studentId and sets the full name
	 * (firstName + lastName) in the marksheet.
	 * 
	 * @param dto          MarksheetDTO object
	 * @param userContext  UserContext containing user/session details
	 */
	@Override
	protected void populate(MarksheetDTO dto, UserContext userContext) {

		StudentDTO studentdto = studentDao.findByPK(dto.getStudentId(), userContext);

		dto.setName(studentdto.getFirstName() + "" + studentdto.getLastName());

	}

	/**
	 * Builds dynamic where clause conditions based on the values
	 * provided in MarksheetDTO.
	 * 
	 * It filters records using name and roll number.
	 * 
	 * @param dto     MarksheetDTO containing search criteria
	 * @param builder CriteriaBuilder for creating predicates
	 * @param qRoot   Root reference of MarksheetDTO entity
	 * @return List of Predicate conditions
	 */
	@Override
	protected List<Predicate> getWhereClause(MarksheetDTO dto, CriteriaBuilder builder, Root<MarksheetDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();
		
		if (!isEmptyString(dto.getName())) {
			whereCondition.add(builder.like(qRoot.get("name"), dto.getName()  +  "%"));
		}
		
		if (!isEmptyString(dto.getRollNo())) {
			whereCondition.add(builder.like(qRoot.get("rollNo"), dto.getRollNo() + "%"));
		}

		return whereCondition;
	}

	

}