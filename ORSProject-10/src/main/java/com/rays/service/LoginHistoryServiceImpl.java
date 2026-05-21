package com.rays.service;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.LoginHistoryDAOInt;
import com.rays.dto.LoginHistoryDTO;


@Service
public class LoginHistoryServiceImpl extends BaseServiceImpl<LoginHistoryDTO, LoginHistoryDAOInt> implements LoginHistoryServiceInt{

}
