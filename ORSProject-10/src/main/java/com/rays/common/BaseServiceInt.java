package com.rays.common;

import java.util.List;

/**
 * BaseServiceInt is a generic service interface that defines standard
 * CRUD operations for any DTO type. Concrete service classes should
 * implement this interface to provide database operations via DAO.
 *
 * @param <T> Type of DTO extending BaseDTO
 */
public interface BaseServiceInt<T extends BaseDTO> {

    /**
     * Adds a new DTO record to the database.
     *
     * @param dto The DTO to add
     * @param userContext Context of the current user
     * @return Generated primary key of the added record
     */
    public long add(T dto, UserContext userContext);

    /**
     * Updates an existing DTO record in the database.
     *
     * @param dto The DTO to update
     * @param userContext Context of the current user
     */
    public void update(T dto, UserContext userContext);

    /**
     * Saves a DTO record. Adds a new record if ID is null,
     * otherwise updates the existing record.
     *
     * @param dto The DTO to save
     * @param userContext Context of the current user
     * @return ID of the saved record
     */
    public long save(T dto, UserContext userContext);

    /**
     * Deletes a DTO record by its ID.
     *
     * @param id The ID of the record to delete
     * @param userContext Context of the current user
     * @return The deleted DTO object
     */
    public T delete(long id, UserContext userContext);

    /**
     * Finds a DTO record by its primary key.
     *
     * @param id The primary key of the record
     * @param userContext Context of the current user
     * @return DTO object if found, null otherwise
     */
    public T findById(long id, UserContext userContext);

    /**
     * Finds a DTO by a unique attribute value.
     *
     * @param attribute The attribute name
     * @param val The value of the attribute
     * @param userContext Context of the current user
     * @return DTO object if found, null otherwise
     */
    public T findByUniqueKey(String attribute, String val, UserContext userContext);

    /**
     * Searches for DTO records with pagination.
     *
     * @param dto Example DTO containing search criteria
     * @param pageNo Page number (starting from 0)
     * @param pageSize Number of records per page
     * @param userContext Context of the current user
     * @return List of matching DTO objects
     */
    public List search(T dto, int pageNo, int pageSize, UserContext userContext);

    /**
     * Searches for DTO records without pagination.
     *
     * @param dto Example DTO containing search criteria
     * @param userContext Context of the current user
     * @return List of matching DTO objects
     */
    public List search(T dto, UserContext userContext);

}