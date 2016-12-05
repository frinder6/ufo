package com.ufo.service.impl;

import com.ufo.entity.DictInfoEntity;
import com.ufo.mapper.impl.DictInfoEntityMapperImpl;
import com.ufo.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by frinder6 on 2016/11/27.
 */
@Service("dictService")
public class DictServiceImpl implements DictService {

    @Autowired
    private DictInfoEntityMapperImpl dictInfoEntityMapperImpl;

    /**
     * 根据 name 加载字典数据
     *
     * @param name
     * @return
     */
    @Override
    public List<DictInfoEntity> selectByName(String name) {
        return dictInfoEntityMapperImpl.selectByName(name);
    }
}
