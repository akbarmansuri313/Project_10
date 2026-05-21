package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.ServerMonitorDTO;

@Repository
public class ServerMonitorDAOImpl extends BaseDAOImpl<ServerMonitorDTO> implements ServerMonitorDAOInt{

	@Override
	public Class<ServerMonitorDTO> getDTOClass() {

		return ServerMonitorDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(ServerMonitorDTO dto, CriteriaBuilder builder,
			Root<ServerMonitorDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();
		
		if (!isEmptyString(dto.getCpuUsage())) {
			
			whereCondition.add(builder.like(qRoot.get("cpuUsage"), dto.getCpuUsage() + "%"));
			
		}
		
		if (!isEmptyString(dto.getStatus())) {

			
			whereCondition.add(builder.like(qRoot.get("status"), dto.getStatus() + "%"));
			
		}
		
		return whereCondition;
	}

}
