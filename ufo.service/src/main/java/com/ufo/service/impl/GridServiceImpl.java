package com.ufo.service.impl;

import com.google.common.base.CaseFormat;
import com.google.common.collect.Collections2;
import com.ufo.entity.EasyuiFieldTemplate;
import com.ufo.entity.EasyuiFormTemplate;
import com.ufo.entity.EasyuiGridResult;
import com.ufo.entity.EasyuiGridTemplate;
import com.ufo.entity.GridButtonInfoEntity;
import com.ufo.entity.GridColumnInfoEntity;
import com.ufo.entity.GridExtendInfoEntity;
import com.ufo.entity.GridInfoEntity;
import com.ufo.entity.Page;
import com.ufo.mapper.GridInfoEntityMapper;
import com.ufo.mapper.impl.GridButtonInfoEntityMapperImpl;
import com.ufo.mapper.impl.GridColumnInfoEntityMapperImpl;
import com.ufo.mapper.impl.GridExtendInfoEntityMapperImpl;
import com.ufo.mapper.impl.GridInfoEntityMapperImpl;
import com.ufo.mapper.impl.SystemDatabaseMapperImpl;
import com.ufo.service.GridService;
import com.ufo.vo.ColumnsVO;
import com.ufo.vo.TableVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
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
    private GridInfoEntityMapper gridInfoEntityMapper;

    @Autowired
    private GridExtendInfoEntityMapperImpl gridExtendInfoEntityMapperImpl;

    @Autowired
    private GridButtonInfoEntityMapperImpl gridButtonInfoEntityMapperImpl;

    @Autowired
    private SystemDatabaseMapperImpl systemDatabaseMapperImpl;


    /**
     * 加载grid extend 数据
     *
     * @param gridId
     * @return
     */
    @Override
    public GridExtendInfoEntity getGridExtendInfoByGridId(Long gridId) {
        return gridExtendInfoEntityMapperImpl.selectByGridId(gridId);
    }


    /**
     * 新增grid
     *
     * @param entity
     */
    @Override
    public void insert(GridInfoEntity entity) {
        gridInfoEntityMapper.insertSelective(entity);
    }

    /**
     * 删除grid
     *
     * @param id
     */
    @Override
    public void delete(Long id) {
        gridInfoEntityMapper.deleteByPrimaryKey(id);
    }

    /**
     * 更新grid
     *
     * @param entity
     */
    @Override
    public void update(GridInfoEntity entity) {
        gridInfoEntityMapper.updateByPrimaryKeySelective(entity);
    }


    /**
     * 批量插入 grid columns 配置信息
     *
     * @param columnsVO
     */
    @Override
    public void batchInsertSelective(ColumnsVO columnsVO) {
        gridColumnInfoEntityMapperImpl.batchInsertSelective(columnsVO);
    }


    /**
     * 分页查询配置 grid 记录
     *
     * @param page
     * @param entity
     * @return
     */
    @Override
    public EasyuiGridResult selectPage(Page page, GridInfoEntity entity) {
        EasyuiGridResult result = new EasyuiGridResult();
        int count = gridInfoEntityMapperImpl.selectPageCount(entity);
        List<GridInfoEntity> list = gridInfoEntityMapperImpl.selectPage(page, entity);
        result.setTotal(count);
        result.setRows(list);
        return result;
    }


    /**
     * 分页查询系统表
     *
     * @param page
     * @return
     */
    @Override
    public EasyuiGridResult selectTablePage(Page page) {
        EasyuiGridResult result = new EasyuiGridResult();
        List<TableVO> list = systemDatabaseMapperImpl.selectTablePage();
        result.setTotal(list.size());
        result.setRows(list);
        return result;
    }


    /**
     * 分页查询系统表列
     *
     * @param page
     * @param tableName
     * @param gridId
     * @return
     */
    @Override
    public EasyuiGridResult selectTableColumnPage(Page page, String tableName, Long gridId) {
        EasyuiGridResult result = new EasyuiGridResult();
        List<GridColumnInfoEntity> list = systemDatabaseMapperImpl.selectTableColumnPage(tableName, gridId);
        result.setTotal(list.size());
        result.setRows(list);
        return result;
    }


    /**
     * 分页查询 grid 配置 columns 对象
     *
     * @param page
     * @param entity
     * @return
     */
    @Override
    public EasyuiGridResult selectColumnPage(Page page, GridColumnInfoEntity entity) {
        EasyuiGridResult result = new EasyuiGridResult();
        int count = gridColumnInfoEntityMapperImpl.selectPageCount(entity);
        List<GridColumnInfoEntity> list = gridColumnInfoEntityMapperImpl.selectPage(page, entity);
        result.setTotal(count);
        result.setRows(list);
        return result;
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
                    EasyuiFormTemplate formTemplate = new EasyuiFormTemplate();
                    // 添加返回字符串
                    formTemplate.setSearch(form(Collections2.filter(columnInfoEntityList, (GridColumnInfoEntity o) -> o.getSearchable()), "搜索"));
                    formTemplate.setInsert(form(Collections2.filter(columnInfoEntityList, (GridColumnInfoEntity o) -> o.getInsertable()), "提交"));
                    formTemplate.setModify(form(Collections2.filter(columnInfoEntityList, (GridColumnInfoEntity o) -> o.getModifyable()), "提交"));
                    map.put(entity.getName().toLowerCase(), formTemplate);
                }
            }
        }
    }


    /**
     * 将列转换为form html代码
     *
     * @param fieldTemplates
     * @param text
     * @return
     */
    private StringBuilder form(Collection<GridColumnInfoEntity> fieldTemplates, String text) {
        StringBuilder result = new StringBuilder();
        if (!CollectionUtils.isEmpty(fieldTemplates)) {
            result.append("<form id=\"form\" class=\"easyui-form\" method=\"post\" data-options=\"novalidate:true\">");
            for (GridColumnInfoEntity entity : fieldTemplates) {
                result.append("<div style=\"margin-bottom:20px\">")
                        .append("<input")
                        .append(" class=\"").append(entity.getType()).append("\"")
                        .append(" name=\"").append(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, entity.getField())).append("\"")
                        .append(" style=\"width:100%\"")
                        .append(" label=\"").append(entity.getTitle()).append("\"")
                        .append(" required=\"").append(entity.getRequired()).append("\"")
                        .append(" validType=\"").append(entity.getValidType()).append("\"")
                        .append(" value=\"").append(entity.getValue()).append("\"")
                        .append(" data-options=\"").append(entity.getDataOptions()).append("\"")
                        .append(">")
                        .append("</div>");
            }
            result.append("<div style=\"text-align:center;padding:5px 0\">")
                    .append("<a id=\"btnOk\" href=\"javascript:void(0)\" class=\"easyui-linkbutton\" style=\"width:80px\">")
                    .append(text)
                    .append("</a>")
                    .append("<a id=\"btnCancel\" href=\"javascript:void(0)\" class=\"easyui-linkbutton\" style=\"width:80px\">重置</a>")
                    .append("</div>")
                    .append("</form>");
        }
        return result;
    }


}
