package com.ufo.mapper.impl;

import com.ufo.entity.LogInfoEntity;
import com.ufo.entity.LogInfoEntityWithBLOBs;
import com.ufo.entity.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by frinder6 on 2016/12/8.
 */
public interface LogInfoEntityMapperImpl {

    List<LogInfoEntityWithBLOBs> selectPage(@Param("p") Page page, @Param("e") LogInfoEntity entity);

    int selectPageCount(@Param("e") LogInfoEntity entity);
}
