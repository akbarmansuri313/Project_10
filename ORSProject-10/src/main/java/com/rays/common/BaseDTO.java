package com.rays.common;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

/**
 * BaseDTO is an abstract superclass for all DTO (Data Transfer Object) classes.
 * It provides common fields like id, createdBy, modifiedBy, createdDatetime, 
 * and modifiedDatetime which are shared across multiple tables.
 * It also implements the DropdownList interface for UI dropdown support.
 */
@MappedSuperclass
public abstract class BaseDTO implements DropdownList  {

    /** Unique identifier for each record */
    @Id
    @GeneratedValue(generator = "ncsPk")
    @GenericGenerator(name = "ncsPk", strategy = "native")
    @Column(name = "id", unique = true, nullable = false)
    protected Long id;

    /** User who created the record */
    @Column(name = "created_by", length = 50)
    protected String createdBy = "root";

    /** User who last modified the record */
    @Column(name = "modified_by", length = 50)
    protected String modifiedBy = "root";

    /** Timestamp when the record was created */
    @Column(name = "created_datetime")
    protected Timestamp createdDatetime;

    /** Timestamp when the record was last modified */
    @Column(name = "modified_datetime")
    protected Timestamp modifiedDatetime;

    /**
     * Returns the unique key field name for the DTO.
     * Each subclass should implement this method.
     * 
     * @return Unique key field name
     */
    public abstract String getUniqueKey();

    /**
     * Returns the unique value corresponding to the unique key for the DTO.
     * Each subclass should implement this method.
     * 
     * @return Unique key value
     */
    public abstract String getUniqueValue();

    /**
     * Returns the label for the DTO.
     * Typically used for display purposes.
     * 
     * @return Label of the DTO
     */
    public abstract String getLabel();

    /**
     * Returns the database table name for the DTO.
     * 
     * @return Table name
     */
    public abstract String getTableName();

    /** @return The ID of the record */
    public Long getId() {
        return id;
    }

    /** @param id The ID to set for the record */
    public void setId(Long id) {
        this.id = id;
    }

    /** @return User who created the record */
    public String getCreatedBy() {
        return createdBy;
    }

    /** @param createdBy User who created the record */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /** @return User who last modified the record */
    public String getModifiedBy() {
        return modifiedBy;
    }

    /** @param modifiedBy User who last modified the record */
    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    /** @return Timestamp when the record was created */
    public Timestamp getCreatedDatetime() {
        return createdDatetime;
    }

    /** @param createdDatetime Set timestamp when the record was created */
    public void setCreatedDatetime(Timestamp createdDatetime) {
        this.createdDatetime = createdDatetime;
    }

    /** @return Timestamp when the record was last modified */
    public Timestamp getModifiedDatetime() {
        return modifiedDatetime;
    }

    /** @param modifiedDatetime Set timestamp when the record was last modified */
    public void setModifiedDatetime(Timestamp modifiedDatetime) {
        this.modifiedDatetime = modifiedDatetime;
    }

    /**
     * Returns the key value for dropdown lists.
     * Typically, the ID is used as the key.
     * 
     * @return String representation of the record ID
     */
    public String getKey() {
        return String.valueOf(id);
    }

    /**
     * Returns the display value for dropdown lists.
     * Subclasses should override this method to provide meaningful value.
     * 
     * @return Display value (default null)
     */
    @Override
    public String getValue() {
        return null;
    }
}