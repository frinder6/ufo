package com.ufo.service.impl;

import com.ufo.dao.MenuInfoEntityDao;
import com.ufo.entity.GridResult;
import com.ufo.entity.MenuInfoEntity;
import com.ufo.mapper.MenuInfoEntityMapper;
import com.ufo.service.MenuService;
import com.ufo.vo.MenuInfoVO;
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
    private MenuInfoEntityDao menuInfoEntityDao;

    @Autowired
    private MenuInfoEntityMapper menuInfoEntityMapper;


    @Override
    public List<MenuInfoVO> selectMenu(Long pid) {
        return menuInfoEntityDao.selectByPid(pid);
    }

    @Override
    public List<MenuTreeInfoVO> selectTree(Long pid) {
        return menuInfoEntityDao.selectTreeByPid(pid);
    }


    @Override
    public GridResult selectPage(MenuInfoEntity entity) {
        GridResult result = new GridResult();
        result.setTotal(menuInfoEntityDao.selectPageCount(entity));
        result.setRecords(menuInfoEntityDao.selectPage(entity));
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
