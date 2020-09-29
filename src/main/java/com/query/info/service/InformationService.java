package com.query.info.service;

import com.github.pagehelper.PageInfo;
import com.query.info.common.InfoResponse;
import com.query.info.dto.InformationDto;
import com.query.info.entity.Information;

import java.io.InputStream;

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
}
