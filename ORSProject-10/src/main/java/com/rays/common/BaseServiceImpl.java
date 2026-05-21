package com.rays.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.rays.exception.DatabaseException;
import com.rays.exception.DuplicateRecordException;

/**
 * BaseServiceImpl is a generic service implementation class that provides
 * common CRUD operations for any DTO type. It delegates actual database
 * operations to the corresponding DAO implementation.
 *
 * @param <T> Type of DTO extending BaseDTO
 * @param <D> Type of DAO extending BaseDAOInt for the DTO
 */
public class BaseServiceImpl<T extends BaseDTO, D extends BaseDAOInt<T>> implements BaseServiceInt<T> {

    /** DAO instance for database operations */
    @Autowired
    protected D baseDao;

    /**
     * Adds a new DTO record to the database.
     *
     * @param dto The DTO to add
     * @param userContext The context of the current user
     * @return Generated primary key of the added record
     * @throws DuplicateRecordException if a duplicate record is found
     */
    @Transactional(readOnly = false)
    public long add(T dto, UserContext userContext) throws DuplicateRecordException {
        long pk = baseDao.add(dto, userContext);
        return pk;
    }

    /**
     * Updates an existing DTO record in the database.
     *
     * @param dto The DTO to update
     * @param userContext The context of the current user
     * @throws DuplicateRecordException if a duplicate record is found
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(T dto, UserContext userContext) throws DuplicateRecordException {
    	
        T oldDto = baseDao.findByPK(dto.getId(), userContext);
        
        if (oldDto != null) {
            dto.setCreatedBy(oldDto.getCreatedBy());
            dto.setCreatedDatetime(oldDto.getCreatedDatetime());
        }
        baseDao.update(dto, userContext);
    }

    /**
     * Saves a DTO record. Adds a new record if ID is null, otherwise updates the existing record.
     *
     * @param dto The DTO to save
     * @param userContext The context of the current user
     * @return ID of the saved record
     * @throws DuplicateRecordException if a duplicate record is found
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public long save(T dto, UserContext userContext) throws DuplicateRecordException {
    	
        Long id = dto.getId();
        
        if (id != null && id > 0) {
            update(dto, userContext);
            
        } else {
            id = add(dto, userContext);
        }
        return id;
    }

    /**
     * Finds a DTO by its primary key.
     *
     * @param id The primary key of the record
     * @param userContext The context of the current user
     * @return DTO object if found, null otherwise
     */
    @Transactional(readOnly = true)
    public T findById(long id, UserContext userContext) {
    	
        T dto = baseDao.findByPK(id, userContext);
        
        return dto;
    }

    /**
     * Deletes a DTO record by its ID.
     *
     * @param id The ID of the record to delete
     * @param userContext The context of the current user
     * @return The deleted DTO object
     * @throws DatabaseException if the record is not found
     */
    @Transactional(propagation = Propagation.REQUIRED)    
    public T delete(long id, UserContext userContext) {
    	
        T dto = findById(id, userContext);
        
        if (dto == null) {
            throw new DatabaseException("Record not found");
        }
        baseDao.delete(dto, userContext);
        return dto;
    }

    /**
     * Finds a DTO by a unique attribute value.
     *
     * @param attribute The attribute name
     * @param val The value of the attribute
     * @param userContext The context of the current user
     * @return DTO object if found, null otherwise
     */
    @Transactional(readOnly = true)
    public T findByUniqueKey(String attribute, String val, UserContext userContext) {
        T dto = baseDao.findByUniqueKey(attribute, val, userContext);
        return dto;
    }

    /**
     * Searches for DTO records with pagination.
     *
     * @param dto Example DTO containing search criteria
     * @param pageNo Page number (starting from 0)
     * @param pageSize Number of records per page
     * @param userContext The context of the current user
     * @return List of matching DTOs
     */
    @Transactional(readOnly = true)
    public List<T> search(T dto, int pageNo, int pageSize, UserContext userContext) {
        return baseDao.search(dto, pageNo, pageSize, userContext);
    }

    /**
     * Searches for DTO records without pagination.
     *
     * @param dto Example DTO containing search criteria
     * @param userContext The context of the current user
     * @return List of matching DTOs
     */
    @Transactional(readOnly = true)
    public List<T> search(T dto, UserContext userContext) {
        return baseDao.search(dto, userContext);
    }
}