package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.NFTAssetDTO;
import com.rays.form.NFTAssetForm;
import com.rays.service.NFTAssetServiceInt;

@RestController
@RequestMapping(value = "Nft")
public class NFTAssetCtl extends BaseCtl<NFTAssetForm, NFTAssetDTO, NFTAssetServiceInt> {

}
