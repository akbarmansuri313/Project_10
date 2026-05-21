package com.rays.service;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.QRScannerDAOInt;
import com.rays.dto.QRScannerDTO;


@Service
public class QRScannerServiceImpl extends BaseServiceImpl<QRScannerDTO, QRScannerDAOInt> implements QRScannerServiceInt{

}
