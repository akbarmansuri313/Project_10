package com.rays.service;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.NotificationDAOInt;
import com.rays.dto.NotificationDTO;

@Service
public class NotificationServiceImpl extends BaseServiceImpl<NotificationDTO, NotificationDAOInt> implements NotificationServiceInt{

}
