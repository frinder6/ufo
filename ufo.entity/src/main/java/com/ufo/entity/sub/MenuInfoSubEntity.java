package com.ufo.entity.sub;

import com.ufo.entity.MenuInfoEntity;
import lombok.Data;

import java.util.List;

/**
 * Created by frinder6 on 2016/11/16.
 */
@Data
public class MenuInfoSubEntity extends MenuInfoEntity {

    private int pageSize = 1000;
    private int pageNumber = 1;
    private int pageFrom = 0;
    private String field = "id";
    private String direction = "ASC";


    private List<MenuInfoSubEntity> children;

}
