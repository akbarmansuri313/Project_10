package com.rays.service;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.AccountStatusDAOInt;
import com.rays.dto.AccountStatusDTO;

@Service
public class AccountStatusServiceImpl extends BaseServiceImpl<AccountStatusDTO, AccountStatusDAOInt> implements AccountStatusServiceInt{

}
