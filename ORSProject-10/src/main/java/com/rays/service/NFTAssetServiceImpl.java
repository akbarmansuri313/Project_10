package com.rays.service;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.NFTAssetDAOInt;
import com.rays.dto.NFTAssetDTO;


@Service
public class NFTAssetServiceImpl extends BaseServiceImpl<NFTAssetDTO, NFTAssetDAOInt> implements NFTAssetServiceInt{

}
