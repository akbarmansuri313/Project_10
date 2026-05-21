package com.rays.service;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.CloudStorageDAOInt;
import com.rays.dto.CloudStorageDTO;

@Service
public class CloudStorageServiceImpl extends BaseServiceImpl<CloudStorageDTO, CloudStorageDAOInt> implements CloudStorageServiceInt{

}
