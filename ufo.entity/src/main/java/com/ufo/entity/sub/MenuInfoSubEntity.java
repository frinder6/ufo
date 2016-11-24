package com.ufo.entity.sub;

import com.ufo.entity.MenuInfoEntity;
import lombok.Data;

import java.util.List;

/**
 * Created by frinder6 on 2016/11/16.
 */
@Data
public class MenuInfoSubEntity extends MenuInfoEntity {

    private List<MenuInfoSubEntity> children;

}
