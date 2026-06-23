package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.PetAdoptionDTO;
import com.rays.form.PetAdoptionForm;
import com.rays.service.PetAdoptionServiceInt;

@RestController
@RequestMapping(value = "Pet")
public class PetAdoptionCtl extends BaseCtl<PetAdoptionForm, PetAdoptionDTO, PetAdoptionServiceInt>{

}
