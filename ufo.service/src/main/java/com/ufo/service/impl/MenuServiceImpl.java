package com.ufo.service.impl;

import com.ufo.entity.MenuInfoEntity;
import com.ufo.entity.EasyuiGridResult;
import com.ufo.entity.Page;
import com.ufo.entity.sub.MenuInfoSubEntity;
import com.ufo.mapper.MenuInfoEntityMapper;
import com.ufo.mapper.impl.MenuInfoEntityMapperImpl;
import com.ufo.service.MenuService;
import com.ufo.vo.MenuTreeInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by frinder6 on 2016/11/3.
 */
@Service("menuService")
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuInfoEntityMapperImpl menuInfoEntityMapperImpl;

    @Autowired
    private MenuInfoEntityMapper menuInfoEntityMapper;


    @Override
    public List<MenuInfoSubEntity> selectMenu(Long pid) {
        return menuInfoEntityMapperImpl.selectByPid(pid);
    }

    @Override
    public List<MenuTreeInfoVO> selectTree(Long pid) {
        return menuInfoEntityMapperImpl.selectTreeByPid(pid);
    }


    @Override
    public int selectPageCount(MenuInfoEntity entity) {
        return menuInfoEntityMapperImpl.selectPageCount(entity);
    }


    @Override
    public EasyuiGridResult selectPage(Page page, MenuInfoEntity entity) {
        EasyuiGridResult result = new EasyuiGridResult();
        int count = menuInfoEntityMapperImpl.selectPageCount(entity);
        List<MenuInfoEntity> list = menuInfoEntityMapperImpl.selectPage(page, entity);
        result.setTotal(count);
        result.setRows(list);
        return result;
    }

    @Override
    public MenuInfoEntity findById(Long id) {
        return menuInfoEntityMapper.selectByPrimaryKey(id);
    }


    @Override
    public Long insert(MenuInfoEntity record) {
        menuInfoEntityMapper.insertSelective(record);
        return record.getId();
    }


    @Override
    public void update(MenuInfoEntity record) {
        menuInfoEntityMapper.updateByPrimaryKeySelective(record);
    }


    @Override
    public void delete(Long id) {
        menuInfoEntityMapper.deleteByPrimaryKey(id);
    }

}
