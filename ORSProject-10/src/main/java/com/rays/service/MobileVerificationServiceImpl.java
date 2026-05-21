package com.rays.service;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.MobileVerificationDAOInt;
import com.rays.dto.MobileVerificationDTO;


@Service
public class MobileVerificationServiceImpl extends BaseServiceImpl<MobileVerificationDTO, MobileVerificationDAOInt> implements MobileVerificationServiceInt{

}
