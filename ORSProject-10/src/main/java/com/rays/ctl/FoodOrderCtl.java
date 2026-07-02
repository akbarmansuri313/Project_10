package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rays.common.BaseCtl;
import com.rays.dto.FoodOrderDTO;
import com.rays.form.FoodOrderForm;
import com.rays.service.FoodOrderServiceInt;

@RestController
@RequestMapping(value = "Food")
public class FoodOrderCtl extends BaseCtl<FoodOrderForm, FoodOrderDTO, FoodOrderServiceInt>{

}
