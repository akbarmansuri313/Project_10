package com.rays.ctl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.dto.ServerMonitorDTO;
import com.rays.form.ServerMonitorForm;
import com.rays.service.ServerMonitorServiceInt;

@RestController
@RequestMapping(value = "Server")
public class ServerMonitorCtl extends BaseCtl<ServerMonitorForm, ServerMonitorDTO, ServerMonitorServiceInt>{

}
