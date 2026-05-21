package com.rays.common;

/**
 * BaseForm is a generic form class that provides common fields 
 * and functionality for all form objects in the application.
 * It acts as a base class for specific form DTOs.
 */
public class BaseForm {

    /** Unique identifier for the form */
    protected Long id;

    /** User who created the record */
    protected String createdBy;

    /** User who last modified the record */
    protected String modifiedBy;

    /** Creation timestamp in milliseconds */
    protected long createdDatetime;

    /** Modification timestamp in milliseconds */
    protected long modifiedDatetime;

    /** Array of IDs for batch operations */
    private Long[] ids;

    /** Current page number for pagination */
    private int pageNo = 0;

    /** Number of records per page for pagination */
    private int pageSize = 5;

    /** Operation to be performed (e.g., save, delete, update) */
    private String operation;

    /**
     * Returns the ID of the form.
     * 
     * @return Form ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the form.
     * 
     * @param id Form ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the corresponding DTO object.
     * Subclasses should override this method to return a proper DTO.
     * 
     * @return BaseDTO instance (default null)
     */
    public BaseDTO getDto() {
        return null;
    }

    /**
     * Initializes the given DTO with the form's ID.
     * If ID is present and greater than 0, it sets the DTO's ID; otherwise sets null.
     * 
     * @param <T> Type of DTO extending BaseDTO
     * @param dto The DTO object to initialize
     * @return Initialized DTO
     */
    public <T extends BaseDTO> T initDTO(T dto) {
        if (id != null && id > 0) {
            dto.setId(id);
        } else {
            dto.setId(null);
        }
        return dto;
    }
}