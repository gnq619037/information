package com.query.info.controller;

import com.github.pagehelper.PageInfo;
import com.query.info.common.InfoResponse;
import com.query.info.dto.InformationDto;
import com.query.info.entity.Information;
import com.query.info.service.InformationService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guonanqing
 * @version 1.0
 * @desc
 * @date 2020/9/28 15:44
 */
@RestController
@RequestMapping("/information.sql")
public class InformationController {

    @Autowired
    private InformationService informationService;

    @RequiresPermissions("query")
    @PostMapping("/page")
    public InfoResponse<PageInfo<Information>> page(@RequestBody InformationDto informationDto){
        return informationService.listInformation(informationDto);
    }
}
