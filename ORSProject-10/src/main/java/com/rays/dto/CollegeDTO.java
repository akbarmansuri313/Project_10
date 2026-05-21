package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

/**
 * @author Akbar Mansuri
 * CollegeDTO represents a college entity in the system.
 * <p>
 * This class extends {@link BaseDTO} and contains information about
 * a college, including its name, address, state, city, and contact number.
 * It is mapped to the "st_college" table in the database.
 */
@Entity
@Table(name = "st_college")
public class CollegeDTO extends BaseDTO {

    /** Name of the college (unique) */
    @Column(name = "name", length = 50)
    private String name;

    /** Address of the college */
    @Column(name = "address", length = 50)
    private String address;

    /** State in which the college is located */
    @Column(name = "state", length = 50)
    private String state;

    /** City in which the college is located */
    @Column(name = "city", length = 50)
    private String city;

    /** Contact phone number of the college */
    @Column(name = "phone_no", length = 15)
    private String phoneNo;

    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
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
     * @return name of the college
     */
    @Override
    public String getUniqueValue() {
        return name;
    }

    /**
     * Returns a human-readable label for this DTO.
     *
     * @return "College Name"
     */
    @Override
    public String getLabel() {
        return "College Name";
    }

    /**
     * Returns the database table name associated with this DTO.
     *
     * @return "College"
     */
    @Override
    public String getTableName() {
        return "College";
    }

    /**
     * Returns the display value of this DTO for dropdowns or lists.
     *
     * @return name of the college
     */
    @Override
    public String getValue() {
        return name;
    }
}