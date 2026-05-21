package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * RoleDTO represents a user role entity in the system.
 * <p>
 * This class extends {@link BaseDTO} and contains information about the role name
 * and description. It is mapped to the "st_role" table in the database.
 */
@Entity
@Table(name = "st_role")
public class RoleDTO extends BaseDTO {

    /** Name of the role */
    @Column(name = "name", length = 50)
    private String name = null;

    /** Description of the role */
    @Column(name = "description", length = 100)
    private String description = null;

    // Getters and setters with field-level documentation

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the unique key field for this DTO.
     * 
     * @return "name" as the unique key
     */
    @Override
    public String getUniqueKey() {
        return "name";
    }

    /**
     * Returns the unique value for this DTO based on the unique key.
     * 
     * @return the role name
     */
    @Override
    public String getUniqueValue() {
        return name;
    }

    /**
     * Returns a human-readable label for this DTO.
     * 
     * @return "Role Name"
     */
    @Override
    public String getLabel() {
        return "Role Name";
    }

    /**
     * Returns the database table name associated with this DTO.
     * 
     * @return "Role"
     */
    @Override
    public String getTableName() {
        return "Role";
    }

    /**
     * Returns the value to be used in dropdown lists.
     * 
     * @return the role name
     */
    
    
    @Override
    public String getKey() {
        return name;
    }
    
    
    @Override
    public String getValue() {
        return name;
    }
}