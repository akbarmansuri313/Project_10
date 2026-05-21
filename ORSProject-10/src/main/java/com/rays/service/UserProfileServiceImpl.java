package com.rays.service;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.UserProfileDAOInt;
import com.rays.dto.UserProfileDTO;

@Service
public class UserProfileServiceImpl extends BaseServiceImpl<UserProfileDTO, UserProfileDAOInt> implements UserProfileServiceInt{

}
