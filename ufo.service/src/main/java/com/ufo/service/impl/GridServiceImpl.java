package com.ufo.service.impl;

import com.google.common.base.CaseFormat;
import com.ufo.entity.EasyuiFormTemplate;
import com.ufo.entity.EasyuiGridResult;
import com.ufo.entity.EasyuiGridTemplate;
import com.ufo.entity.GridButtonInfoEntity;
import com.ufo.entity.GridColumnInfoEntity;
import com.ufo.entity.GridExtendInfoEntity;
import com.ufo.entity.GridInfoEntity;
import com.ufo.entity.Page;
import com.ufo.mapper.impl.GridButtonInfoEntityMapperImpl;
import com.ufo.mapper.impl.GridColumnInfoEntityMapperImpl;
import com.ufo.mapper.impl.GridExtendInfoEntityMapperImpl;
import com.ufo.mapper.impl.GridInfoEntityMapperImpl;
import com.ufo.mapper.impl.SystemDatabaseMapperImpl;
import com.ufo.service.GridService;
import com.ufo.vo.TableVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by frinder6 on 2016/11/3.
 */
@Service("gridService")
public class GridServiceImpl implements GridService {


    @Autowired
    private GridColumnInfoEntityMapperImpl gridColumnInfoEntityMapperImpl;

    @Autowired
    private GridInfoEntityMapperImpl gridInfoEntityMapperImpl;

    @Autowired
    private GridExtendInfoEntityMapperImpl gridExtendInfoEntityMapperImpl;

    @Autowired
    private GridButtonInfoEntityMapperImpl gridButtonInfoEntityMapperImpl;

    @Autowired
    private SystemDatabaseMapperImpl systemDatabaseMapperImpl;


    @Override
    public EasyuiGridResult selectPage(Page page, GridInfoEntity entity) {
        EasyuiGridResult result = new EasyuiGridResult();
        int count = gridInfoEntityMapperImpl.selectPageCount(entity);
        List<GridInfoEntity> list = gridInfoEntityMapperImpl.selectPage(page, entity);
        result.setTotal(count);
        result.setRows(list);
        return result;
    }


    @Override
    public EasyuiGridResult selectTablePage(Page page) {
        EasyuiGridResult result = new EasyuiGridResult();
        List<TableVO> list = systemDatabaseMapperImpl.selectTablePage();
        result.setTotal(list.size());
        result.setRows(list);
        return result;
    }

    @Override
    public EasyuiGridResult selectTableColumnPage(Page page, String tableName, Long gridId) {
        EasyuiGridResult result = new EasyuiGridResult();
        List<GridColumnInfoEntity> list = systemDatabaseMapperImpl.selectTableColumnPage(tableName, gridId);
        result.setTotal(list.size());
        result.setRows(list);
        return result;
    }


    @Override
    public EasyuiGridResult selectColumnPage(Page page, GridColumnInfoEntity entity) {
        EasyuiGridResult result = new EasyuiGridResult();
        int count = gridColumnInfoEntityMapperImpl.selectPageCount(entity);
        List<GridColumnInfoEntity> list = gridColumnInfoEntityMapperImpl.selectPage(page, entity);
        result.setTotal(count);
        result.setRows(list);
        return result;
    }


    @Override
    public EasyuiGridTemplate selectGrid(String gridName) {
        GridInfoEntity gridInfoEntity = gridInfoEntityMapperImpl.selectByName(gridName);
        if (null != gridInfoEntity) {
            return null;
        } else {
            throw new NullPointerException("表格：[ " + gridName + " ]未配置，请联系管理员！");
        }
    }


    /**
     * 初始化加载grid配置，并放在static map中
     *
     * @param map
     * @throws Exception
     */
    @Override
    public void loadValidGridList(Map<String, EasyuiGridTemplate> map) throws Exception {
        List<GridInfoEntity> gridInfoEntityList = gridInfoEntityMapperImpl.selectValidList();
        if (!CollectionUtils.isEmpty(gridInfoEntityList)) {
            // 临时变量
            EasyuiGridTemplate gridTemplate;
            long gridId;
            GridExtendInfoEntity extendInfoEntity;
            boolean frozen;
            List<GridColumnInfoEntity> columnInfoEntityList;
            List<GridButtonInfoEntity> buttonInfoEntityList;
            List<EasyuiGridTemplate.Column> columns;
            List<EasyuiGridTemplate.Column> frozenColumns;
            EasyuiGridTemplate.Column column;
            EasyuiGridTemplate.Toolbar toolbar;
            // 逐条处理grid配置信息
            for (GridInfoEntity entity : gridInfoEntityList) {
                gridTemplate = new EasyuiGridTemplate();
                gridId = entity.getId();
                // grid基本配置
                extendInfoEntity = gridExtendInfoEntityMapperImpl.selectByGridId(gridId);
                if (null != extendInfoEntity) {
                    BeanUtils.copyProperties(extendInfoEntity, gridTemplate);
                }
                // columns/frozen columns配置
                columnInfoEntityList = gridColumnInfoEntityMapperImpl.selectByGridId(gridId);
                if (!CollectionUtils.isEmpty(columnInfoEntityList)) {
                    columns = new ArrayList<>();
                    frozenColumns = new ArrayList<>();
                    for (GridColumnInfoEntity columnInfoEntity : columnInfoEntityList) {
                        column = new EasyuiGridTemplate.Column();
                        BeanUtils.copyProperties(columnInfoEntity, column);
                        frozen = columnInfoEntity.getFrozen();
                        if (frozen) {
                            frozenColumns.add(column);
                        } else {
                            columns.add(column);
                        }
                    }
                    gridTemplate.getColumns().add(columns);
                    gridTemplate.getFrozenColumns().add(frozenColumns);
                }
                // grid toolbar配置
                buttonInfoEntityList = gridButtonInfoEntityMapperImpl.selectByGridId(gridId);
                if (!CollectionUtils.isEmpty(buttonInfoEntityList)) {
                    for (GridButtonInfoEntity buttonInfoEntity : buttonInfoEntityList) {
                        toolbar = new EasyuiGridTemplate.Toolbar();
                        BeanUtils.copyProperties(buttonInfoEntity, toolbar);
                        gridTemplate.getToolbar().add(toolbar);
                    }
                }
                map.put(entity.getName().toLowerCase(), gridTemplate);
            }
        }
    }


    /**
     * 初始化grid对应的 search/insert/update form
     *
     * @param map
     * @throws Exception
     */
    @Override
    public void loadValidFormList(Map<String, EasyuiFormTemplate> map) throws Exception {
        List<GridInfoEntity> gridInfoEntityList = gridInfoEntityMapperImpl.selectValidList();
        if (!CollectionUtils.isEmpty(gridInfoEntityList)) {
            long gridId;
            for (GridInfoEntity entity : gridInfoEntityList) {
                gridId = entity.getId();
                // 查询grid对应的列
                List<GridColumnInfoEntity> columnInfoEntityList = gridColumnInfoEntityMapperImpl.selectByGridId(gridId);
                if (!CollectionUtils.isEmpty(columnInfoEntityList)) {
                    List<GridColumnInfoEntity> searchList = new ArrayList<>();
                    List<GridColumnInfoEntity> insertList = new ArrayList<>();
                    List<GridColumnInfoEntity> modifyList = new ArrayList<>();
                    boolean searchable, insertable, modifyable;
                    for (GridColumnInfoEntity columnInfoEntity : columnInfoEntityList) {
                        searchable = columnInfoEntity.getSearchable();
                        insertable = columnInfoEntity.getInsertable();
                        modifyable = columnInfoEntity.getModifyable();
                        if (searchable) {
                            searchList.add(columnInfoEntity);
                        }
                        if (insertable) {
                            insertList.add(columnInfoEntity);
                        }
                        if (modifyable) {
                            modifyList.add(columnInfoEntity);
                        }
                    }
                    EasyuiFormTemplate formTemplate = new EasyuiFormTemplate();
                    if (!CollectionUtils.isEmpty(searchList)) {
                        formTemplate.setSearch(form(searchList, "搜索"));
                    }
                    if (!CollectionUtils.isEmpty(insertList)) {
                        formTemplate.setInsert(form(insertList, "提交"));
                    }
                    if (!CollectionUtils.isEmpty(modifyList)) {
                        formTemplate.setModify(form(modifyList, "提交"));
                    }
                    map.put(entity.getName().toLowerCase(), formTemplate);
                }
            }
        }
    }


    /**
     * 将列转换为form html代码
     *
     * @param columnInfoEntityList
     * @param text
     * @return
     */
    private StringBuilder form(List<GridColumnInfoEntity> columnInfoEntityList, String text) {
        StringBuilder result = new StringBuilder();
        if (!CollectionUtils.isEmpty(columnInfoEntityList)) {
            String textTemplate = "<div style=\"margin-bottom:20px\"><input class=\"easyui-%s\" name=\"%s\" style=\"width:100%%\" data-options=\"label:'%s：',required:%b%s\"></div>";
            String treeTemplate = "<div style=\"margin-bottom:20px\"><select class=\"easyui-%s\" name=\"%s\" style=\"width:100%%\" data-options=\"label:'%s：',required:%b%s\"></select></div>";
            result.append("<form id=\"form\" class=\"easyui-form\" method=\"post\" data-options=\"novalidate:true\">");
            String type;
            StringBuilder append;
            for (GridColumnInfoEntity columnInfoEntity : columnInfoEntityList) {
                type = columnInfoEntity.getType();
                append = new StringBuilder(",url:").append(columnInfoEntity.getUrl());
                if ("textbox".equalsIgnoreCase(type) || "datebox".equalsIgnoreCase(type)) {
                    result.append(String.format(textTemplate, type, CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, columnInfoEntity.getField()), columnInfoEntity.getTitle(), columnInfoEntity.getRequired(), ""));
                } else if ("combotree".equalsIgnoreCase(type)) {
                    result.append(String.format(treeTemplate, type, CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, columnInfoEntity.getField()), columnInfoEntity.getTitle(), columnInfoEntity.getRequired(), append));
                } else if ("combobox".equalsIgnoreCase(type)) {
                    result.append(String.format(textTemplate, type, CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, columnInfoEntity.getField()), columnInfoEntity.getTitle(), columnInfoEntity.getRequired(), append));
                }
            }
            result.append("<div style=\"text-align:center;padding:5px 0\">").
                    append("<a id=\"btnOk\" href=\"javascript:void(0)\" class=\"easyui-linkbutton\" style=\"width:80px\">" + text + "</a>").
                    append("<a id=\"btnCancel\" href=\"javascript:void(0)\" class=\"easyui-linkbutton\" style=\"width:80px\">重置</a>").
                    append("</div>");
            result.append("</form>");
        }
        return result;
    }


}
