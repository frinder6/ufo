package com.ufo.entity.sub;

import com.ufo.entity.MenuInfoEntity;
import lombok.Data;

/**
 * Created by frinder6 on 2016/11/16.
 */
@Data
public class MenuInfoSubEntity extends MenuInfoEntity {

    private int pageSize = 1000;
    private int pageNumber = 1;
    private int pageFrom = 0;

}
