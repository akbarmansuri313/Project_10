package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.RoleDTO;

/**
 * RoleForm is a form class used for capturing and transferring
 * role-related data from the presentation layer to the business layer.
 * <p>
 * This form extends BaseForm and includes validation constraints for
 * role name and description. It provides a method to convert itself
 * into a RoleDTO object for persistence.
 */
public class RoleForm extends BaseForm {

    /** Role type constants */
    public static final int ADMIN = 1;
    public static final int STUDENT = 2;
    public static final int FACULTY = 3;
    public static final int KIOSK = 4;

    /** Name of the role (required) */
    @NotEmpty(message = "Name is required")
    private String name;

    /** Description of the role (required) */
    @NotEmpty(message = "Description is required")
    private String description;

    // Getters and Setters

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
     * Converts this form into a RoleDTO object for persistence.
     *
     * @return a populated RoleDTO instance containing the form data
     */
    @Override
    public BaseDTO getDto() {
        RoleDTO dto = initDTO(new RoleDTO());
        dto.setDescription(description);
        dto.setName(name);
        return dto;
    }
}