package com.rays.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_qrscanner")
public class QRScannerDTO extends BaseDTO {

	@Column(name = "qrCode", length = 50)
	private String qrCode;

	@Column(name = "scannedBy", length = 50)
	private String scannedBy;

	@Column(name = "scanDate", length = 50)
	private Date scanDate;

	@Column(name = "status", length = 50)
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
	public String getUniqueKey() {

		return "qrCode";
	}

	@Override
	public String getUniqueValue() {

		return qrCode;
	}

	@Override
	public String getLabel() {
		return "QR Code";
	}

	@Override
	public String getTableName() {

		return "QR Scanner";
	}

}
