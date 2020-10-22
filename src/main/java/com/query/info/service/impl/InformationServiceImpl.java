package com.query.info.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.query.info.common.InfoResponse;
import com.query.info.dao.InformationMapper;
import com.query.info.dto.InformationDto;
import com.query.info.entity.Information;
import com.query.info.service.InformationService;
import com.query.info.util.ExcelUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @Override
    public InfoResponse<String> inputData(List<Information> information) {
        informationMapper.insertInformationList(information);
        return new InfoResponse<String>().code(0);
    }

    @Override
    public InfoResponse<String> exportData(InformationDto informationDto) {
        String[] keys = {"codeBatch","expertCode","expertName","sex","birthDate","cardType","cardNumber","country","outside",
                "cnName","insideHome","insideLiveReachDay","bankAccountName","bankCode","bankName","unionBankCode","telPhone","email",
                "schoolCode","schoolName","payAmount","tax","realPayAmount","currentStatus","reviewNum","settlementStatus","failStatus",
                "publishTime","publishBatch","publishResult","publishNum","fundType","infoFlag","backAccountVerify","publishFailMsg","publishFailUseFlag",
                "pastBatch","messageStatus"};
        String[] columnNames = {};
        List<Information> informationList = informationMapper.queryInformation(informationDto);
        String dataStr = JSONObject.toJSONString(informationList);
        List<Map<String, String>> mapList = JSONArray.parseObject(dataStr, List.class);
        Workbook workbook = ExcelUtil.createWorkBook(mapList, keys, columnNames);

        return null;
    }

    @Override
    public List<Map<String, String>> queryData(InformationDto informationDto) {
        List<Information> informationList = informationMapper.queryInformation(informationDto);
        String dataStr = JSONObject.toJSONString(informationList);
        List<Map<String, String>> mapList = JSONArray.parseObject(dataStr, List.class);
        return mapList;
    }
}
