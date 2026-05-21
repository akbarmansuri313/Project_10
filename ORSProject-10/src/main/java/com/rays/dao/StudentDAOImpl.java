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
import com.rays.dto.StudentDTO;

/**
 * Data Access Object implementation for {@link StudentDTO} entities.
 * <p>
 * Provides database operations for students, including CRUD methods
 * inherited from {@link BaseDAOImpl}. Handles additional population
 * of associated entities such as College information.
 * </p>
 */
@Repository
public class StudentDAOImpl extends BaseDAOImpl<StudentDTO> implements StudentDAOInt {

    @Autowired
    private CollegeDAOImpl cdao;

    /**
     * Returns the class type of {@link StudentDTO}.
     */
    @Override
    public Class<StudentDTO> getDTOClass() {
        return StudentDTO.class;
    }

    /**
     * Constructs the WHERE clause predicates for querying {@link StudentDTO}.
     * Currently returns an empty list, no additional filtering applied.
     *
     * @param dto the DTO containing filter criteria
     * @param builder the CriteriaBuilder for constructing predicates
     * @param qRoot the root of the query
     * @return a list of {@link Predicate} objects for the query
     */
    @Override
    protected List<Predicate> getWhereClause(StudentDTO dto, CriteriaBuilder builder, Root<StudentDTO> qRoot) {
        List<Predicate> whereCondition = new ArrayList<>();
        
       
        if (dto.getId()!= null) {
        	
        	whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
			
		}
        
        if (!isEmptyString(dto.getEmail())) {
        	
        	whereCondition.add(builder.like(qRoot.get("email"), dto.getEmail() + "%"));
			
		}
        
        if (dto.getEnrolNo() != null) {

        	whereCondition.add(builder.equal(qRoot.get("enrolNo"), dto.getEnrolNo()));
        	
			
		}
        
        return whereCondition;
    }

    /**
     * Populates additional fields in {@link StudentDTO}, such as college name,
     * by fetching related entities from the database.
     *
     * @param dto the DTO to populate
     * @param userContext the current user's context
     */
    @Override
    protected void populate(StudentDTO dto, UserContext userContext) {
        CollegeDTO dto1 = cdao.findByPK(dto.getCollegeId(), userContext);
        dto.setCollegeName(dto1.getName());
    }
}