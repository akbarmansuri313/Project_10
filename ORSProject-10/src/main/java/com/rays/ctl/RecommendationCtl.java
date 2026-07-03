package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.RecommendationDTO;
import com.rays.form.RecommendationForm;
import com.rays.service.RecommendationServiceInt;


@RestController
@RequestMapping(value = "Recommendation")
public class RecommendationCtl extends BaseCtl<RecommendationForm, RecommendationDTO, RecommendationServiceInt>{

}
