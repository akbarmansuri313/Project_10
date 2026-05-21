package com.rays.service;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.ServerMonitorDAOInt;
import com.rays.dto.ServerMonitorDTO;


@Service
public class ServerMonitorServiceImpl extends BaseServiceImpl<ServerMonitorDTO, ServerMonitorDAOInt> implements ServerMonitorServiceInt{

}
