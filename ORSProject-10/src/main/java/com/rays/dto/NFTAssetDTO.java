package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_nft")
public class NFTAssetDTO extends BaseDTO {

	@Column(name = "ngtCode", length = 20)
	private String nftCode;

	@Column(name = "assetName", length = 20)
	private String assetName;

	@Column(name = "ownerName", length = 20)
	private String ownerName;

	@Column(name = "status", length = 20)
	private String status;

	public String getNftCode() {
		return nftCode;
	}

	public void setNftCode(String nftCode) {
		this.nftCode = nftCode;
	}

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String getUniqueKey() {

		
		return "nftCode";
	}

	@Override
	public String getUniqueValue() {

		return nftCode;
	}

	@Override
	public String getLabel() {

		return "NFT Code";
	}

	@Override
	public String getTableName() {

		return "NFT";
	}
	
	
	

}
