package com.rays.dto;

import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import com.rays.common.BaseDTO;

/**
 * 
 * @author Akbar Mansuri
 * UserDTO represents the User entity for the application.
 * <p>
 * This class extends {@link BaseDTO} and contains user-specific fields
 * such as first name, last name, login credentials, role information,
 * contact details, status, and audit timestamps.
 * <p>
 * It also provides constants for common user statuses: ACTIVE, DEACTIVE, and LOCKED.
 */
@Entity
@Table(name = "st_user")
public class UserDTO extends BaseDTO {

    /** Status representing an active user */
    public static final String ACTIVE = "Active";

    /** Status representing a deactive user */
    public static final String DEACTIVE = "Deactive";

    /** Status representing a locked user */
    public static final String LOCKED = "Locked";

    /** User's first name */
    @Column(name = "first_name", length = 50)
    private String firstName;

    /** User's last name */
    @Column(name = "last_name", length = 50)
    private String lastName;

    /** User login ID */
    @Column(name = "login_id", length = 50)
    private String loginId;

    /** User password */
    @Column(name = "password", length = 50)
    private String password;

    /** Role ID associated with the user */
    @Column(name = "role_id")
    private Long roleId;

    /** Role name associated with the user */
    @Column(name = "role_name", length = 50)
    private String roleName = null;

    /** Date of birth */
    @Column(name = "dob")
    private Date dob;

    /** Gender */
    @Column(name = "gender", length = 10)
    private String gender;

    /** Primary phone number */
    @Column(name = "phone", length = 50)
    private String phone;

    /** Alternate mobile number */
    @Column(name = "alternate_mobile", length = 50)
    private String alternateMobile;

    /** User status (Active, Deactive, Locked) */
    @Column(name = "status", length = 20)
    private String status;

    /** Timestamp of last login */
    @Column(name = "last_login")
    private Timestamp lastLogin;

    /** Count of unsuccessful login attempts */
    @Column(name = "unsucess_login")
    private Integer unsucessfullLoginAttempt = 0;

    /** Associated image ID */
    @Column(name = "image_id")
    private Long imageId;

    // Getters and Setters with field-level JavaDoc

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAlternateMobile() {
        return alternateMobile;
    }

    public void setAlternateMobile(String alternateMobile) {
        this.alternateMobile = alternateMobile;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Integer getUnsucessfullLoginAttempt() {
        return unsucessfullLoginAttempt;
    }

    public void setUnsucessfullLoginAttempt(Integer unsucessfullLoginAttempt) {
        this.unsucessfullLoginAttempt = unsucessfullLoginAttempt;
    }

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    /**
     * Returns the full name of the user by concatenating first name and last name.
     *
     * @return Full name of the user
     */
    public String getName() {
        return firstName + " " + lastName;
    }

    /**
     * Returns the unique key field for this DTO.
     * 
     * @return the unique key, "loginId"
     */
    @Override
    public String getUniqueKey() {
        return "loginId";
    }

    /**
     * Returns the unique value of the DTO based on the unique key.
     * 
     * @return the value of courseName
     */

    @Override
    public String getUniqueValue() {
        return loginId;
    }

    /**
     * Returns a human-readable label for this DTO.
     * 
     * @return null, no specific label defined
     */
    @Override
    public String getLabel() {
        return "Login Id";
    }
    /**
     * Returns the table name associated with this DTO.
     * 
     * @return "User"
     */

    @Override
    public String getTableName() {
        return "User";
    }
    
    
    @Override
    public String getKey() {
    	
    	return id + "";
    }
    
    @Override
    public String getValue() {
    	
    	return "id";
    }
}