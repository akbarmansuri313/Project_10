package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.NFTAssetDTO;

@Repository
public class NFTAssetDAOImpl extends BaseDAOImpl<NFTAssetDTO> implements NFTAssetDAOInt {

	@Override
	public Class<NFTAssetDTO> getDTOClass() {

		return NFTAssetDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(NFTAssetDTO dto, CriteriaBuilder builder, Root<NFTAssetDTO> qRoot) {

		List<Predicate> whereConditon = new ArrayList<Predicate>();
		
		if (!isEmptyString(dto.getNftCode())) {
			
			whereConditon.add(builder.like(qRoot.get("nftCode"), dto.getNftCode() + "%"));
			
		}
		
		if (!isEmptyString(dto.getOwnerName())) {
			
			whereConditon.add(builder.like(qRoot.get("ownerName"), dto.getOwnerName() + "%"));
			
		}
		
		return whereConditon;
	}

}
