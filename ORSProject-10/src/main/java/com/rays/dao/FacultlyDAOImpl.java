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
import com.rays.dto.CollegeDTO;
import com.rays.dto.CourseDTO;
import com.rays.dto.FacultyDTO;
import com.rays.dto.SubjectDTO;

/**
 * FacultlyDAOImpl is the implementation class for FacultyDAOInt interface.
 * 
 * It extends BaseDAOImpl to provide basic CRUD operations and 
 * implements custom logic specific to FacultyDTO.
 * 
 * This class handles database interactions related to faculty,
 * including dynamic query building and populating related data
 * such as subject, course, and college names.
 * 
 * @author Akbar Mansuri
 */
@Repository
public class FacultlyDAOImpl extends BaseDAOImpl<FacultyDTO> implements FacultyDAOInt{

	@Autowired
	SubjectDAOInt subjectDao;

	@Autowired
	CourseDAOInt courseDao;

	@Autowired
	CollegeDAOInt collegeDao;

	/**
	 * Returns the class type of FacultyDTO.
	 * 
	 * @return Class of FacultyDTO
	 */
	@Override
	public Class<FacultyDTO> getDTOClass() {
		return FacultyDTO.class;
	}

	/**
	 * Builds dynamic where clause conditions based on the values
	 * provided in FacultyDTO.
	 * 
	 * Currently filters data based on first name.
	 * 
	 * @param dto     FacultyDTO containing search criteria
	 * @param builder CriteriaBuilder for creating predicates
	 * @param qRoot   Root reference of FacultyDTO entity
	 * @return List of Predicate conditions
	 */
	@Override
	protected List<Predicate> getWhereClause(FacultyDTO dto, CriteriaBuilder builder, Root<FacultyDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();
		
		if (!isEmptyString(dto.getFirstName())) {
			whereCondition.add(builder.like(qRoot.get("firstName"), dto.getFirstName() + "%"));
		}

		if (!isEmptyString(dto.getCollegeName())) {
			whereCondition.add(builder.like(qRoot.get("collegeName"), dto.getCollegeName() + "%"));
		}
		return whereCondition;
	}

	/**
	 * Populates additional fields in FacultyDTO before saving or updating.
	 * 
	 * It fetches related entities such as Subject, Course, and College
	 * using their respective IDs and sets their names in the DTO.
	 * 
	 * @param dto         FacultyDTO object
	 * @param userContext UserContext containing user/session details
	 */
	@Override
	protected void populate(FacultyDTO dto, UserContext userContext) {

		SubjectDTO subjectDTO = subjectDao.findByPK(dto.getSubjectId(), userContext);
		dto.setSubjectName(subjectDTO.getName());

		CourseDTO courseDTO = courseDao.findByPK(dto.getCourseId(), userContext);
		dto.setCourseName(courseDTO.getName());

		CollegeDTO collegeDTO = collegeDao.findByPK(dto.getCollegeId(), userContext);
		dto.setCollegeName(collegeDTO.getName());
	}

}