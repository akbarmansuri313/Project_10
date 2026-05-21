package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.QRScannerDTO;
import com.rays.form.QRScannerForm;
import com.rays.service.QRScannerServiceInt;

@RestController
@RequestMapping(value = "Qrscanner")
public class QRscannerCtl extends BaseCtl<QRScannerForm, QRScannerDTO, QRScannerServiceInt>{
	

}
