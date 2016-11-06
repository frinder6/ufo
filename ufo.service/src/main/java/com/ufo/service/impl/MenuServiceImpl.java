package com.ufo.service.impl;

import com.ufo.dao.MenuInfoEntityDao;
import com.ufo.entity.DxDataEntity;
import com.ufo.entity.MenuInfoEntity;
import com.ufo.service.MenuService;
import com.ufo.vo.MenuInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by frinder6 on 2016/11/3.
 */
@Service("menuService")
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuInfoEntityDao menuInfoEntityDao;


    @Override
    public List<MenuInfoVO> selectMenu(Long pid) {
        return menuInfoEntityDao.selectByPid(pid);
    }


    @Override
    public void selectPage(DxDataEntity dx, MenuInfoEntity entity) {
        int count = menuInfoEntityDao.selectCount(dx, entity);
        List<MenuInfoEntity> menuInfoEntityList = menuInfoEntityDao.selectPage(dx, entity);
        dx.setTotal_count(count);
        dx.setData(menuInfoEntityList);
    }

}
