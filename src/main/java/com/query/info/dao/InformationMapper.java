package com.query.info.dao;

import com.query.info.dto.InformationDto;
import com.query.info.entity.Information;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author guonanqing
 * @version 1.0
 * @desc
 * @date 2020/9/28 15:21
 */
@Mapper
public interface InformationMapper {

    /**
     * 查询
     * @param informationDto
     * @return
     */
    public List<Information> queryInformation(InformationDto informationDto);
}
