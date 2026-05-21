package com.rays.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.QRScannerDTO;

public class QRScannerForm  extends BaseForm{

	@NotEmpty(message = "QR Code is Required")
	private String qrCode;

	@NotEmpty(message = "Scanned By is Required")
	private String scannedBy;

	@NotNull(message = "Scan Date is Required")
	private Date scanDate;

	@NotEmpty(message = "status is Required")
	private String status;

	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	public String getScannedBy() {
		return scannedBy;
	}

	public void setScannedBy(String scannedBy) {
		this.scannedBy = scannedBy;
	}

	public Date getScanDate() {
		return scanDate;
	}

	public void setScanDate(Date scanDate) {
		this.scanDate = scanDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public BaseDTO getDto() {
		
		QRScannerDTO dto  = initDTO(new QRScannerDTO());
		
		dto.setQrCode(qrCode);
		dto.setScanDate(scanDate);
		dto.setScannedBy(scannedBy);
		dto.setStatus(status);
		
		return dto;
	}

}
