package com.ufo.entity.sub;

import com.ufo.entity.MenuInfoEntity;
import lombok.Data;

/**
 * Created by frinder6 on 2016/11/16.
 */
@Data
public class MenuInfoSubEntity extends MenuInfoEntity {

    private int pageSize = 20;
    private int pageNumber = 1;
    private int pageFrom;

    public int getPageFrom() {
        if (pageNumber < 1) pageNumber = 1;
        return (pageNumber - 1) * pageSize;
    }

}
