package com.rays.common;

import com.rays.dto.UserDTO;

/**
 * UserContext class holds information about the currently logged-in user.
 * It provides easy access to the user's ID, login, name, role, and full UserDTO object.
 * This class is typically stored in session and passed across services for authorization and auditing.
 */
public class UserContext {

    /** User ID of the logged-in user */
    private Long userId = 0L;

    /** Login ID of the user (username/email) */
    private String loginId = "root";

    /** Name of the user */
    private String name = null;

    /** Role ID of the user */
    private Long roleId = 0L;

    /** Role name of the user */
    private String roleName = "root";

    /** Full UserDTO object for additional user details */
    private UserDTO userDTO = null;

    /**
     * Default constructor.
     * Initializes a default root user context.
     */
    public UserContext() {
    }

    /**
     * Constructs a UserContext from a given UserDTO.
     *
     * @param dto UserDTO object containing user information
     */
    public UserContext(UserDTO dto) {
        this.userDTO = dto;
        this.userId = dto.getId();
        this.loginId = dto.getLoginId();
        this.name = dto.getName();
        this.roleId = dto.getRoleId();
        this.roleName = dto.getRoleName();
    }

    /**
     * Returns the user ID.
     *
     * @return user ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * Sets the user ID.
     *
     * @param userId user ID to set
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * Returns the login ID.
     *
     * @return login ID
     */
    public String getLoginId() {
        return loginId;
    }

    /**
     * Sets the login ID.
     *
     * @param loginId login ID to set
     */
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    /**
     * Returns the user's name.
     *
     * @return user name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the user's name.
     *
     * @param name user name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the role ID.
     *
     * @return role ID
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * Sets the role ID.
     *
     * @param roleId role ID to set
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * Returns the role name.
     *
     * @return role name
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * Sets the role name.
     *
     * @param roleName role name to set
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * Returns the full UserDTO object.
     *
     * @return UserDTO object
     */
    public UserDTO getUserDTO() {
        return userDTO;
    }

    /**
     * Sets the UserDTO object.
     *
     * @param userDTO UserDTO to set
     */
    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
}