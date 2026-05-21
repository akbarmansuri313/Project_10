package com.rays.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * LoginForm is a simple form class used to capture user login credentials.
 * <p>
 * Validation constraints ensure that:
 * <ul>
 *   <li>Login Id is required and must be a valid email address</li>
 *   <li>Password is required</li>
 * </ul>
 */
public class LoginForm {

    /** User login id (email) - required */
    @NotEmpty(message = "Login Id is required")
    @Email(message = "Login Id must be a valid email")
    private String loginId;

    /** User password - required */
    @NotEmpty(message = "Password is required")
    private String password;

    // Getters and Setters
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
}