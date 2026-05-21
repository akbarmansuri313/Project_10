package com.rays.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Form class for changing a user's password.
 * Provides validation for old and new passwords.
 */
public class ChangePasswordForm {

    @NotEmpty(message = "Old Password is required")
    @Size(min = 2, max = 10, message = "Old Password must be between 2 and 10 characters")
    private String oldPassword;

    @NotEmpty(message = "New Password is required")
    @Size(min = 2, max = 10, message = "New Password must be between 2 and 10 characters")
    private String newPassword;

    @NotEmpty(message = "Login ID is required")
    private String loginId;

    // Getters and Setters
    public String getOldPassword() { return oldPassword; }
    public void setOldPassword(String oldPassword) { this.oldPassword = oldPassword; }

    public String getNewPassword() { return newPassword; }
    public void setNewPassword(String newPassword) { this.newPassword = newPassword; }

    public String getLoginId() { return loginId; }
    public void setLoginId(String loginId) { this.loginId = loginId; }
}