package com.query.info.service;

import com.github.pagehelper.PageInfo;
import com.query.info.common.InfoResponse;
import com.query.info.dto.InformationDto;
import com.query.info.entity.Information;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * @author guonanqing
 * @version 1.0
 * @desc
 * @date 2020/9/28 15:23
 */
public interface InformationService {
    /**
     * 查询分页
     * @param informationDto
     * @return
     */
    public InfoResponse<PageInfo<Information>> listInformation(InformationDto informationDto);

    /**
     * 导出
     * @param informationDto
     * @return
     */
    public InfoResponse<String> exportInformation(InformationDto informationDto);

    /**
     * 导入
     * @param inputStream
     * @return
     */
    public InfoResponse<String> uploadInformation(InputStream inputStream);

    /**
     * 批量
     * @param information
     * @return
     */
    public InfoResponse<String> inputData(List<Information> information);

    /**
     * 导出
     * @param informationDto
     * @return
     */
    public InfoResponse<String> exportData(InformationDto informationDto);

    public List<Map<String, String>> queryData(InformationDto informationDto);
}
