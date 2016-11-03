package com.ufo.service;

import com.ufo.entity.DxGridTemplate;

/**
 * Created by frinder6 on 2016/11/3.
 */
public interface GridService {

    DxGridTemplate selectGrid(String gridName) throws NullPointerException;

}
