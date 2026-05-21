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
import com.rays.dto.TimeTableDTO;

/**
 * Implementation of {@link TimeTableDAOInt} interface.
 * <p>
 * Provides data access operations for {@link TimeTableDTO} entities.
 * Handles CRUD operations and entity population with related Course and Subject details.
 * </p>
 */
@Repository
public class TimeTableDAOImpl extends BaseDAOImpl<TimeTableDTO> implements TimeTableDAOInt {

    @Autowired
    CourseDAOInt courseDao;

    @Autowired
    SubjectDAOInt subjectDao;

    /**
     * Returns the {@link TimeTableDTO} class type.
     *
     * @return Class object of TimeTableDTO
     */
    @Override
    public Class<TimeTableDTO> getDTOClass() {
        return TimeTableDTO.class;
    }

    /**
     * Builds the WHERE clause predicates for querying {@link TimeTableDTO}.
     * Currently returns an empty list (no filtering applied).
     *
     * @param dto the TimeTableDTO containing search criteria
     * @param builder CriteriaBuilder for constructing predicates
     * @param qRoot Root of the query
     * @return List of {@link Predicate} objects
     */
    @Override
    protected List<Predicate> getWhereClause(TimeTableDTO dto, CriteriaBuilder builder, Root<TimeTableDTO> qRoot) {
        List<Predicate> whereCondition = new ArrayList<Predicate>();
        
        if (!isZeroNumber(dto.getId())) {
        	
        	whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
			
		}
        
        if (!isEmptyString(dto.getSubjectName())) {
        	
        	whereCondition.add(builder.like(qRoot.get("subjectName"), dto.getSubjectName() +  "%"));
			
		}
        
        return whereCondition;
    }

    /**
     * Populates additional fields in {@link TimeTableDTO} from related entities.
     * Fetches Course and Subject names using their respective DAOs and sets them in the DTO.
     *
     * @param dto the TimeTableDTO to populate
     * @param userContext context of the current user
     */
    @Override
    protected void populate(TimeTableDTO dto, UserContext userContext) {
        CourseDTO coursedto = courseDao.findByPK(dto.getCourseId(), userContext);
        dto.setCourseName(coursedto.getName());

        SubjectDTO subjectDTO = subjectDao.findByPK(dto.getSubjectId(), userContext);
        dto.setSubjectName(subjectDTO.getCourseName());
    }

}