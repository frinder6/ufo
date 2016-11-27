package com.ufo.service;

import com.ufo.entity.DictInfoEntity;
import com.ufo.entity.EasyuiFormTemplate;
import com.ufo.entity.EasyuiGridTemplate;
import com.ufo.entity.GridInfoEntity;
import com.ufo.vo.ColumnsVO;

import java.util.List;
import java.util.Map;

/**
 * Created by frinder6 on 2016/11/3.
 */
public interface DictService {

    List<DictInfoEntity> selectByName(String name);

}
