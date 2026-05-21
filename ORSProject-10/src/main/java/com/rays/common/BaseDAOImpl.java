package com.rays.common;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * @author Akbar Mansuri
 * BaseDAOImpl is an abstract class that provides generic implementation
 * for basic CRUD operations using JPA EntityManager.
 * 
 * @param <T> The type of DTO extending BaseDTO
 */
public abstract class BaseDAOImpl<T extends BaseDTO> implements BaseDAOInt<T> {

    /** EntityManager for interacting with the database */
    @PersistenceContext      
    protected EntityManager entityManager;

    /**
     * Sets the EntityManager instance.
     * 
     * @param entityManager EntityManager to set
     */
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Returns the DTO class type.
     * 
     * @return Class of type T
     */
    public abstract Class<T> getDTOClass();

    /**
     * Constructs the WHERE clause for criteria queries.
     * 
     * @param dto     DTO object containing filter values
     * @param builder CriteriaBuilder instance
     * @param qRoot   Root of the query
     * @return List of predicates for filtering
     */
    protected abstract List<Predicate> getWhereClause(T dto, CriteriaBuilder builder, Root<T> qRoot);

    /**
     * Populates additional fields in the DTO before persistence.
     * Can be overridden in subclasses to set custom values.
     * 
     * @param dto         DTO object to populate
     * @param userContext UserContext of the logged-in user
     */
    protected void populate(T dto, UserContext userContext) {
    }

    /**
     * Adds a new record to the database.
     * 
     * @param dto         DTO to persist
     * @param userContext UserContext of the logged-in user
     * @return ID of the newly created record
     */
    @Override
    public long add(T dto, UserContext userContext) {
    	
        dto.setCreatedBy(userContext.getLoginId());
        
        dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
        
        dto.setModifiedBy(userContext.getLoginId());
        
        dto.setModifiedDatetime(new Timestamp(new Date().getTime()));

        populate(dto, userContext);

        entityManager.persist(dto);

        return dto.getId();
    }

    /**
     * Updates an existing record in the database.
     * 
     * @param dto         DTO to update
     * @param userContext UserContext of the logged-in user
     */
    @Override
    public void update(T dto, UserContext userContext) {
    	
        dto.setModifiedBy(userContext.getLoginId());
        
        dto.setModifiedDatetime(new Timestamp(new Date().getTime()));

        populate(dto, userContext);

        entityManager.merge(dto);
    }

    /**
     * Deletes a record from the database.
     * 
     * @param dto DTO to delete
     * @param userContext UserContext of the logged-in user
     */
    @Override
    public void delete(T dto, UserContext userContext) {
        entityManager.remove(dto);
    }

    /**
     * Finds a record by its primary key.
     * 
     * @param pk          Primary key
     * @param userContext UserContext of the logged-in user
     * @return DTO if found, otherwise null
     */
    @Override
    public T findByPK(long pk, UserContext userContext) {
        return entityManager.find(getDTOClass(), pk);
    }

    /**
     * Finds a record by a unique attribute value.
     * 
     * @param attribute   Attribute name
     * @param val         Value of the attribute
     * @param userContext UserContext of the logged-in user
     * @return DTO if found, otherwise null
     */
    @Override
    public T findByUniqueKey(String attribute, Object val, UserContext userContext) {
    	
        Class<T> dtoClass = getDTOClass();
        
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        
        CriteriaQuery<T> cq = builder.createQuery(dtoClass);
        
        Root<T> qRoot = cq.from(dtoClass);
        
        Predicate condition = builder.equal(qRoot.get(attribute), val);
        
        cq.where(condition);
        
        TypedQuery<T> query = entityManager.createQuery(cq);
        
        List<T> list = query.getResultList();
        
        T dto = null;
        
        if (list.size() > 0) {
        	
        	dto = list.get(0);		
		}
        
        return dto;
    }

    /**
     * Creates a TypedQuery using Criteria API based on the DTO filter.
     * 
     * @param dto         DTO object containing filter values
     * @param userContext UserContext of the logged-in user
     * @return TypedQuery ready to execute
     */
    protected TypedQuery<T> createCriteria(T dto, UserContext userContext) {
    	
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        
        CriteriaQuery<T> cq = builder.createQuery(getDTOClass());
        
        Root<T> qRoot = cq.from(getDTOClass());
        
        cq.select(qRoot);
        
        List<Predicate> whereClause = getWhereClause(dto, builder, qRoot);
        
        cq.where(whereClause.toArray(new Predicate[whereClause.size()]));
        
        TypedQuery<T> query = entityManager.createQuery(cq);
        
        return query;
    }

    /**
     * Searches for records with pagination.
     * 
     * @param dto         DTO object containing search criteria
     * @param pageNo      Page number (starting from 0)
     * @param pageSize    Number of records per page
     * @param userContext UserContext of the logged-in user
     * @return List of matching DTOs
     */
    public List search(T dto, int pageNo, int pageSize, UserContext userContext) {
        TypedQuery<T> query = createCriteria(dto, userContext);
        
        if (pageSize > 0) {
        	
            query.setFirstResult(pageNo * pageSize);
            
            query.setMaxResults(pageSize);
        }
        List  list =  query.getResultList();
        
        return list;
    }

   
  

    /**
     * Searches for all records matching the DTO criteria.
     * 
     * @param dto         DTO object containing search criteria
     * @param userContext UserContext of the logged-in user
     * @return List of matching DTOs
     */
    public List search(T dto, UserContext userContext) {
        return search(dto, 0, 0, userContext);
    }

    /**
     * Checks if a String is null or empty.
     * 
     * @param val String to check
     * @return true if null or empty
     */
    protected boolean isEmptyString(String val) {
        return val == null || val.trim().length() == 0;
    }

    /**
     * Checks if a Double value is null or zero.
     * 
     * @param val Double to check
     * @return true if null or zero
     */
    protected boolean isZeroNumber(Double val) {
        return val == null || val == 0;
    }

    /**
     * Checks if a Long value is null or zero.
     * 
     * @param val Long to check
     * @return true if null or zero
     */
    protected boolean isZeroNumber(Long val) {
        return val == null || val == 0;
    }

    /**
     * Checks if an Integer value is null or zero.
     * 
     * @param val Integer to check
     * @return true if null or zero
     */
    protected boolean isZeroNumber(Integer val) {
        return val == null || val == 0;
    }

    /**
     * Checks if an object is not null.
     * 
     * @param val Object to check
     * @return true if object is not null
     */
    protected boolean isNotNull(Object val) {
        return val != null;
    }

}