package com.rays.ctl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.common.UserContext;
import com.rays.config.JWTUtil;
import com.rays.dto.UserDTO;
import com.rays.form.ForgetPasswordForm;
import com.rays.form.LoginForm;
import com.rays.form.UserForm;
import com.rays.form.UserRegistrationForm;
import com.rays.service.UserServiceInt;

/**
 * LoginCtl is a REST controller for authentication-related operations.
 * 
 * It provides endpoints for:
 *  - User login and JWT token generation
 *  - User registration (sign-up)
 *  - User logout
 * 
 * Author: Akbar Mansuri
 */
@RestController
@RequestMapping(value = "Auth")
public class LoginCtl extends BaseCtl<UserForm, UserDTO, UserServiceInt> {
	
	@Autowired
	private JWTUtil jwtUtli;

	/**
	 * Authenticate user and generate JWT token.
	 * 
	 * @param form login credentials
	 * @param bindingResult validation results
	 * @param session HTTP session
	 * @param request HTTP request
	 * @return ORSResponse with user info and JWT token
	 * @throws Exception if token generation fails
	 */
	@PostMapping("login")
	public ORSResponse login(@RequestBody @Valid LoginForm form, BindingResult bindingResult, HttpSession session,
			HttpServletRequest request) throws Exception {

		ORSResponse res = validate(bindingResult);
		if (!res.isSuccess()) {
			return res;
		}

		UserDTO dto = baseService.authenticate(form.getLoginId(), form.getPassword());

		if (dto == null) {
			res.setSuccess(false);
			res.addMessage("Invalid Login ID & Password");
		} else {
			UserContext context = new UserContext(dto);
			
			String token = jwtUtli.generateToken(dto.getId(), dto.getLoginId(), dto.getRoleName());
			
			session.setAttribute("userContext", context);

			res.setSuccess(true);
			res.addData(dto);
			res.addResult("loginId", dto.getLoginId());
			res.addResult("role", dto.getRoleName());
			res.addResult("fname", dto.getFirstName());
			res.addResult("lname", dto.getLastName());
			res.addResult("token", token);
		}
		return res;
	}

	/**
	 * Register a new user.
	 * 
	 * @param form user registration details
	 * @param bindingResult validation results
	 * @return ORSResponse indicating success or failure
	 */
	@PostMapping("signUp")
	public ORSResponse signUp(@RequestBody @Valid UserRegistrationForm form, BindingResult bindingResult) {

		ORSResponse res = validate(bindingResult);
		if (!res.isSuccess()) {
			return res;
		}

		UserDTO dto = baseService.findByLoginId(form.getLoginId(), userContext);
		if (dto != null) {
			res.setSuccess(false);
			res.addMessage("Login Id already exists");
			return res;
		}

		dto = new UserDTO();
		
		dto.setFirstName(form.getFirstName());
		dto.setLastName(form.getLastName());
		dto.setLoginId(form.getLoginId());
		dto.setPassword(form.getPassword());
		dto.setDob(form.getDob());
		dto.setGender(form.getGender());
		dto.setPhone(form.getPhone());
		dto.setStatus("Inactive");
		dto.setRoleId(2L); // default role as Student

		baseService.register(dto);

		res.setSuccess(true);
		res.addMessage("User has been registered successfully..!!");
		return res;
	}
	
	
	/**
	 * Handle forgot password requests and send email.
	 */
	@PostMapping("/forgetPassword")
	public ORSResponse changePassword(@RequestBody @Valid ForgetPasswordForm form, BindingResult bindingResult) {
		ORSResponse res = validate(bindingResult);
		if (!res.isSuccess()) return res;

		boolean flag = baseService.forgotPassword(form.getLoginId());
		if (flag) {
			res.setSuccess(true);
			res.addMessage("Password sent to your email");
		} else {
			res.setSuccess(false);
			res.addMessage("Login Id not found");
		}

		return res;
	}

	/**
	 * Logout the current user by invalidating the session.
	 * 
	 * @param session HTTP session
	 * @return ORSResponse indicating successful logout
	 * @throws Exception if session invalidation fails
	 */
	@GetMapping("logout")
	public ORSResponse logout(HttpSession session) throws Exception {
		ORSResponse res = new ORSResponse();
		session.invalidate();
		res.addMessage("Logout successfully..!!");
		return res;
	}
}