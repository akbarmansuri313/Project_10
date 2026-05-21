package com.rays.common;

import java.util.List;

/**
 * BaseDAOInt is a generic interface that defines
 * basic CRUD operations and search functionality for DTOs.
 * 
 * @param <T> The type of DTO extending BaseDTO
 */
public interface BaseDAOInt<T extends BaseDTO> {

    /**
     * Adds a new record to the database.
     * 
     * @param dto         DTO object to persist
     * @param userContext UserContext of the logged-in user
     * @return ID of the newly created record
     */
    public long add(T dto, UserContext userContext);

    /**
     * Updates an existing record in the database.
     * 
     * @param dto         DTO object to update
     * @param userContext UserContext of the logged-in user
     */
    public void update(T dto, UserContext userContext);

    /**
     * Deletes a record from the database.
     * 
     * @param dto         DTO object to delete
     * @param userContext UserContext of the logged-in user
     */
    public void delete(T dto, UserContext userContext);

    /**
     * Finds a record by its primary key.
     * 
     * @param pk          Primary key of the record
     * @param userContext UserContext of the logged-in user
     * @return DTO object if found, otherwise null
     */
    public T findByPK(long pk, UserContext userContext);

    /**
     * Finds a record by a unique attribute value.
     * 
     * @param attribute   Name of the unique attribute
     * @param val         Value of the attribute
     * @param userContext UserContext of the logged-in user
     * @return DTO object if found, otherwise null
     */
    public T findByUniqueKey(String attribute, Object val, UserContext userContext);

    /**
     * Searches for records with pagination support.
     * 
     * @param dto         DTO object containing search criteria
     * @param pageNo      Page number starting from 0
     * @param pageSize    Number of records per page
     * @param userContext UserContext of the logged-in user
     * @return List of matching DTOs
     */
    public List search(T dto, int pageNo, int pageSize, UserContext userContext);

    /**
     * Searches for all records matching the DTO criteria without pagination.
     * 
     * @param dto         DTO object containing search criteria
     * @param userContext UserContext of the logged-in user
     * @return List of matching DTOs
     */
    public List search(T dto, UserContext userContext);

    

}