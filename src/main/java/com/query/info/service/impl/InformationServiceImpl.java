package com.query.info.service.impl;

import com.github.pagehelper.PageInfo;
import com.query.info.common.InfoResponse;
import com.query.info.dao.InformationMapper;
import com.query.info.dto.InformationDto;
import com.query.info.entity.Information;
import com.query.info.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

/**
 * @author guonanqing
 * @version 1.0
 * @desc
 * @date 2020/9/28 15:41
 */
@Service
public class InformationServiceImpl implements InformationService {

    @Autowired
    private InformationMapper informationMapper;

    @Override
    public InfoResponse<PageInfo<Information>> listInformation(InformationDto informationDto) {
        List<Information> informationList = informationMapper.queryInformation(informationDto);
        PageInfo<Information> pageInfo = new PageInfo<>(informationList);
        return new InfoResponse<PageInfo<Information>>().code(0).message("").result(pageInfo);
    }

    @Override
    public InfoResponse<String> exportInformation(InformationDto informationDto) {
        return null;
    }

    @Override
    public InfoResponse<String> uploadInformation(InputStream inputStream) {
        return null;
    }
}
