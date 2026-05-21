package com.rays.form;

import javax.validation.constraints.NotEmpty;
import com.rays.common.BaseForm;

/**
 * ForgetPasswordForm is used to capture the login ID for password recovery.
 * <p>
 * Validation ensures that the login ID is provided.
 */
public class ForgetPasswordForm extends BaseForm {

    /** User login ID (email or username) - required */
    @NotEmpty(message = "Login Id is required")
    private String loginId;

    // Getter
    public String getLoginId() {
        return loginId;
    }

    // Setter
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }
}