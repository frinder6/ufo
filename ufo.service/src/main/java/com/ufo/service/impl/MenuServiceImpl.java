package com.ufo.service.impl;

import com.ufo.entity.MenuInfoEntity;
import com.ufo.entity.EasyuiGridResult;
import com.ufo.entity.Page;
import com.ufo.entity.sub.MenuInfoSubEntity;
import com.ufo.mapper.MenuInfoEntityMapper;
import com.ufo.mapper.impl.MenuInfoEntityMapperImpl;
import com.ufo.service.MenuService;
import com.ufo.entity.EasyuiTreeTemplate;
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


    /**
     * 加载系统菜单
     *
     * @param pid
     * @return
     */
    @Override
    public List<MenuInfoSubEntity> selectMenu(Long pid) {
        return menuInfoEntityMapperImpl.selectByPid(pid);
    }

    /**
     * 加载系统菜单树
     *
     * @param pid
     * @return
     */
    @Override
    public List<EasyuiTreeTemplate> selectTree(Long pid) {
        return menuInfoEntityMapperImpl.selectTreeByPid(pid);
    }


    /**
     * 查询 menu 记录数量
     *
     * @param entity
     * @return
     */
    @Override
    public int selectPageCount(MenuInfoEntity entity) {
        return menuInfoEntityMapperImpl.selectPageCount(entity);
    }


    /**
     * 分页查询 menu 记录
     *
     * @param page
     * @param entity
     * @return
     */
    @Override
    public EasyuiGridResult selectPage(Page page, MenuInfoEntity entity) {
        EasyuiGridResult result = new EasyuiGridResult();
        int count = menuInfoEntityMapperImpl.selectPageCount(entity);
        List<MenuInfoEntity> list = menuInfoEntityMapperImpl.selectPage(page, entity);
        result.setTotal(count);
        result.setRows(list);
        return result;
    }

    /**
     * 通过id加载 menu
     *
     * @param id
     * @return
     */
    @Override
    public MenuInfoEntity findById(Long id) {
        return menuInfoEntityMapper.selectByPrimaryKey(id);
    }


    /**
     * 新增 menu
     *
     * @param record
     * @return
     */
    @Override
    public Long insert(MenuInfoEntity record) {
        menuInfoEntityMapper.insertSelective(record);
        return record.getId();
    }


    /**
     * 更新 menu
     *
     * @param record
     */
    @Override
    public void update(MenuInfoEntity record) {
        menuInfoEntityMapper.updateByPrimaryKeySelective(record);
    }


    /**
     * 删除 menu
     *
     * @param id
     */
    @Override
    public void delete(Long id) {
        menuInfoEntityMapper.deleteByPrimaryKey(id);
    }

}
