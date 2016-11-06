package com.ufo.service.impl;

import com.google.common.base.CaseFormat;
import com.ufo.dao.GridColumnInfoEntityDao;
import com.ufo.dao.MenuInfoEntityDao;
import com.ufo.entity.DxDataEntity;
import com.ufo.entity.GridColumnInfoEntity;
import com.ufo.entity.GridRow;
import com.ufo.entity.MenuInfoEntity;
import com.ufo.service.MenuService;
import com.ufo.vo.MenuInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * Created by frinder6 on 2016/11/3.
 */
@Service("menuService")
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuInfoEntityDao menuInfoEntityDao;

    @Autowired
    private GridColumnInfoEntityDao gridColumnInfoEntityDao;


    @Override
    public List<MenuInfoVO> selectMenu(Long pid) {
        return menuInfoEntityDao.selectByPid(pid);
    }


    @Override
    public void selectPage(DxDataEntity dx, MenuInfoEntity entity) {
        int count = menuInfoEntityDao.selectCount(dx, entity);
        Map<String, Object> map = getColumns(dx.getGridId());
        dx.setCols((String) map.get("colsStr"));
        List<Map<String, Object>> menuInfoEntityList = menuInfoEntityDao.selectPage(dx, entity);
        List<GridRow> rows = new ArrayList<>();
        if (!CollectionUtils.isEmpty(menuInfoEntityList)) {
            List<String> colList = (List<String>) map.get("colList");
            GridRow row;
            for (Map<String, Object> menuMap : menuInfoEntityList) {
                row = new GridRow();
                row.setId(menuMap.get("id"));
                for (String col : colList) {
                    if ("id".equalsIgnoreCase(col)) {
                        continue;
                    }
                    row.getData().add(menuMap.get(col));
                }
                rows.add(row);
            }
            dx.setRows(rows);
        }
        dx.setTotal_count(count);
    }

    /**
     * 获取配置列
     *
     * @param gridId
     * @return
     */
    private Map<String, Object> getColumns(long gridId) {
        Map<String, Object> map = new HashMap();
        List<GridColumnInfoEntity> gridColumnInfoEntityList = gridColumnInfoEntityDao.selectByGridId(gridId);
        if (!CollectionUtils.isEmpty(gridColumnInfoEntityList)) {
            List<String> colList = new ArrayList() {{
                add("id");
            }};
            StringBuilder colsStr = new StringBuilder("id");
            String name;
            for (GridColumnInfoEntity entity : gridColumnInfoEntityList) {
                name = entity.getName();
                colList.add(name);
                colsStr.append(",").append(name);
            }
            map.put("colsStr", colsStr.toString());
            map.put("colList", colList);
        }
        return map;
    }

}
