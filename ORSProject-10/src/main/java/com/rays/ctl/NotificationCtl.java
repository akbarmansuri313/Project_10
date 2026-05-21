package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rays.common.BaseCtl;
import com.rays.dto.NotificationDTO;
import com.rays.form.NotificationForm;
import com.rays.service.NotificationServiceInt;

/**
 * NotificationCtl is a REST controller for managing notification-related operations.
 * 
 * It provides standard CRUD operations through BaseCtl for NotificationDTO.
 * 
 * Author: Akbar Mansuri
 */
@RestController
@RequestMapping(value = "Notification")
public class NotificationCtl extends BaseCtl<NotificationForm, NotificationDTO, NotificationServiceInt> {

}