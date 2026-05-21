package com.rays.ctl;

import java.io.OutputStream;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.AttachmentDTO;
import com.rays.dto.RoleDTO;
import com.rays.dto.UserDTO;
import com.rays.form.ChangePasswordForm;
import com.rays.form.MyProfileForm;
import com.rays.form.UserForm;
import com.rays.service.AttachmentServiceInt;
import com.rays.service.RoleServiceInt;
import com.rays.service.UserServiceInt;

/**
 * UserCtl is a REST controller for managing user-related operations.
 * 
 * It handles profile management, password changes, and profile picture upload/download.
 * It uses services for User, Role, and Attachment management.
 * 
 * Author: Akbar Mansuri
 */
@RestController
@RequestMapping(value = "User")
public class UserCtl extends BaseCtl<UserForm, UserDTO, UserServiceInt> {

	@Autowired
	RoleServiceInt roleService;

	@Autowired
	UserServiceInt userService;
	
	@Autowired
	AttachmentServiceInt attachmentService;

	/**
	 * Preload roles for dropdown lists.
	 * 
	 * @return ORSResponse with list of roles
	 */
	@GetMapping("preload")
	public ORSResponse preload() {
		
		ORSResponse res = new ORSResponse(true);

		RoleDTO dto = new RoleDTO();
		
		List<RoleDTO> roleList = roleService.search(dto, userContext);
		
		res.addResult("roleList", roleList);

		return res;
	}
	
	/**
	 * Update user profile information.
	 */
	@PostMapping("myProfile")
	public ORSResponse myProfile(@RequestBody @Valid MyProfileForm form, BindingResult bindingResult) {
		ORSResponse res = validate(bindingResult);
		
		if (!res.isSuccess()) {
			return res;
		}

		UserDTO dto = baseService.findById(userContext.getUserId(), userContext);
		dto.setFirstName(form.getFirstName());
		dto.setLastName(form.getLastName());
		dto.setDob(form.getDob());
		dto.setPhone(form.getPhone());
		dto.setGender(form.getGender());

		baseService.update(dto, userContext);
		
		res.setSuccess(true);
		res.addMessage("Your Profile updated successfully..!!");
		return res;
	}

	

	/**
	 * Change user password.
	 */
	@PostMapping("changePassword")
	public ORSResponse changePassword(@RequestBody @Valid ChangePasswordForm form, BindingResult bindingResult) {
		ORSResponse res = validate(bindingResult);
		if (!res.isSuccess()) return res;

		UserDTO changedDto = baseService.changePassword(form.getLoginId(), form.getOldPassword(), form.getNewPassword(), userContext);

		if (changedDto == null) {
			res.setSuccess(false);
			res.addMessage("Invalid old password");
			return res;
		}

		res.setSuccess(true);
		res.addMessage("Password has been changed");
		return res;
	}
	
	/**
	 * Upload user profile picture.
	 */
	@PostMapping("/profilePic/{userId}")
	public ORSResponse uploadPic(@PathVariable Long userId, @RequestParam("file") MultipartFile file, HttpServletRequest req) {
		
		AttachmentDTO attachmentDto = new AttachmentDTO(file);
		
		attachmentDto.setDescription("profile pic");
		
		attachmentDto.setUserId(userId);

		UserDTO userDto = userService.findById(userId, userContext);
		
		if (userDto.getImageId() != null && userDto.getImageId() > 0) {
			
			attachmentDto.setId(userDto.getImageId());
		}

		Long imageId = attachmentService.save(attachmentDto, userContext);

		if (userDto.getImageId() == null) {
			
			userDto.setImageId(imageId);
			
			userService.update(userDto, userContext);
		}

		ORSResponse res = new ORSResponse();
		
		res.addResult("imageId", imageId);
		
		return res;
	}

	/**
	 * Download user profile picture.
	 */
	@GetMapping("/profilePic/{userId}")
	public @ResponseBody void downloadPic(@PathVariable Long userId, HttpServletResponse response) {
		try {
			UserDTO userDto = userService.findById(userId, userContext);
			AttachmentDTO attachmentDTO = null;

			if (userDto != null) {
				attachmentDTO = attachmentService.findById(userDto.getImageId(), userContext);
			}

			if (attachmentDTO != null) {
				response.setContentType(attachmentDTO.getType());
				OutputStream out = response.getOutputStream();
				out.write(attachmentDTO.getDoc());
				out.close();
			} else {
				response.getWriter().write("ERROR: File not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}