package com.ufo.service.impl;

import com.ufo.entity.GridMetadataColumnInfoEntity;
import com.ufo.mapper.GridMetadataColumnInfoEntityMapper;
import com.ufo.service.GridMetadataColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by frinder6 on 2016/11/3.
 */
@Service("gridMetadataColumnService")
public class GridMetadataColumnServiceImpl implements GridMetadataColumnService {


    @Autowired
    private GridMetadataColumnInfoEntityMapper gridMetadataColumnInfoEntityMapper;


    @Override
    public GridMetadataColumnInfoEntity selectById(Long id) {
        return gridMetadataColumnInfoEntityMapper.selectByPrimaryKey(id);
    }


}
