package com.rays.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import com.rays.common.BaseDAOImpl;
import com.rays.dto.QRScannerDTO;


@Repository
public class QRScannerDAOImpl extends BaseDAOImpl<QRScannerDTO> implements QRScannerDAOInt{

	@Override
	public Class<QRScannerDTO> getDTOClass() {
		return QRScannerDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(QRScannerDTO dto, CriteriaBuilder builder, Root<QRScannerDTO> qRoot) {

		
		List<Predicate> whereCondition = new ArrayList<Predicate>();
		
		if (!isEmptyString(dto.getQrCode())) {
			
			whereCondition.add(builder.like(qRoot.get("qrCode"), dto.getQrCode() + "%"));
			
		}
		
		if (!isEmptyString(dto.getScannedBy())) {
			
			whereCondition.add(builder.like(qRoot.get("scannedBy"), dto.getScannedBy() + "%"));
			
		}
		
		return whereCondition;
	}

}
