package com.rays.form;


import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.NFTAssetDTO;

public class NFTAssetForm extends BaseForm{
	

	@NotEmpty(message = "Nft Code is Required")
	private String nftCode;

	@NotEmpty(message = "Asset Name is Required")
	private String assetName;

	@NotEmpty(message = "Owner Name is Required")
	private String ownerName;

	@NotEmpty(message = "Status is Required")
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
	public BaseDTO getDto() {
		
		NFTAssetDTO dto = initDTO(new NFTAssetDTO());
		
		dto.setAssetName(assetName);
		dto.setStatus(status);
		dto.setOwnerName(ownerName);
		dto.setNftCode(nftCode);
		
		return dto;
	}
	

}
