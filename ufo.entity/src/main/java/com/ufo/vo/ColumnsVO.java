package com.ufo.vo;

import com.ufo.entity.GridColumnInfoEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by frinder6 on 2016/11/12.
 */
@Data
public class ColumnsVO {

    private Long gridId;

    private List<GridColumnInfoEntity> entityList = new ArrayList<>();

}
