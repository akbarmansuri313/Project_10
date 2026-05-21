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
import com.rays.dto.RoleDTO;
import com.rays.dto.UserDTO;

/**
 * Data Access Object Implementation for UserDTO.
 * <p>
 * Provides methods to perform CRUD operations on UserDTO entities. Extends the
 * generic BaseDAOImpl and implements UserDAOInt.
 * </p>
 */
@Repository
public class UserDAOImpl extends BaseDAOImpl<UserDTO> implements UserDAOInt {

	/**
	 * Role DAO for fetching role information associated with users.
	 */
	@Autowired
	RoleDAOImpl dao;

	/**
	 * Returns the UserDTO class type.
	 * 
	 * @return Class<UserDTO> representing the UserDTO type.
	 */
	@Override
	public Class<UserDTO> getDTOClass() {
		return UserDTO.class;
	}

	/**
	 * Populates additional fields in the UserDTO before returning it. Currently
	 * sets the roleName of the UserDTO based on the roleId.
	 * 
	 * @param dto         the UserDTO to populate
	 * @param userContext the context of the logged-in user
	 */
	@Override
	protected void populate(UserDTO dto, UserContext userContext) {

		RoleDTO dto1 = dao.findByPK(dto.getRoleId(), userContext);

		dto.setRoleName(dto1.getName());
	}

	/**
	 * Builds the dynamic WHERE clause for UserDTO queries.
	 * <p>
	 * Currently returns an empty list. Can be customized to add predicates based on
	 * search criteria in UserDTO.
	 * </p>
	 * 
	 * @param dto     the UserDTO containing filter criteria
	 * @param builder the CriteriaBuilder used to construct query predicates
	 * @param qRoot   the root of the UserDTO query
	 * @return a List of Predicate objects for the WHERE clause
	 */
	@Override
	protected List<Predicate> getWhereClause(UserDTO dto, CriteriaBuilder builder, Root<UserDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getFirstName())) {

			whereCondition.add(builder.like(qRoot.get("firstName"), dto.getFirstName() + "%"));

		}

		if (!isZeroNumber(dto.getRoleId())) {

			whereCondition.add(builder.equal(qRoot.get("roleId"), dto.getRoleId()));

		}

		if (!isEmptyString(dto.getLoginId())) {

			whereCondition.add(builder.like(qRoot.get("loginId"), dto.getLoginId() + "%"));

		}
		return whereCondition;
	}
}