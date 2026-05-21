package com.rays.common;

/**
 * DropdownList is a generic interface that provides a standard
 * structure for DTOs or objects that can be used to populate
 * dropdown menus in the UI.
 *
 * Implementing classes should provide a unique key and a display
 * value for each option.
 */
public interface DropdownList {

    /**
     * Returns the unique key of the dropdown option.
     *
     * @return Unique key as a String
     */
    public String getKey();

    /**
     * Returns the display value of the dropdown option.
     *
     * @return Display value as a String
     */
    public String getValue();

}