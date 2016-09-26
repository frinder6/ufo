package com.ufo.dao;

import com.google.common.base.CaseFormat;
import com.google.common.collect.Lists;
import com.ufo.entity.Page;
import com.ufo.entity.SqlEntity;
import com.ufo.exception.SqlFormatException;

import java.util.List;

/**
 * Created on 2016/8/1.
 */
public class JdbcUtil<T> {

    private JdbcUtil() {
    }

    public static class SingleFactory {
        public static final JdbcUtil SINGLE = new JdbcUtil();
    }


    /**
     * 下划线转驼峰格式
     *
     * @param resource
     * @return
     */
    public String convert2Camel(String resource) {
        return CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, resource);
    }


    /**
     * @param entity
     * @return
     * @throws SqlFormatException
     */
    public String getInsertSql(SqlEntity<T> entity) throws SqlFormatException {
        String insertSql = "INSERT INTO %s ( %s ) VALUES ( %s )";
        StringBuilder insertCols = new StringBuilder();
        StringBuilder insertValues = new StringBuilder();
        if (!entity.getValueCols().isEmpty()) {
            int i = 0;
            for (String col : entity.getValueCols()) {
                if (i == 0) {
                    insertCols.append(col);
                    insertValues.append(":" + convert2Camel(col));
                } else {
                    insertCols.append(", ".concat(col));
                    insertValues.append(", :" + convert2Camel(col));
                }
                ++i;
            }
            insertCols.append(", create_time");
            insertValues.append(", NOW()");
        } else {
            throw new SqlFormatException(insertSql);
        }
        return String.format(insertSql, entity.getTableName(), insertCols, insertValues);
    }


    /**
     * @param tableName
     * @return
     */
    public String getDeleteSql(String tableName) {
        String deleteSql = "DELETE FROM %s WHERE id = :id";
        return String.format(deleteSql, tableName);
    }

    /**
     * @param entity
     * @return
     */
    public String getWheresDeleteSql(SqlEntity<T> entity) {
        String deleteSql = "DELETE FROM %s WHERE 1 != 1 %s";
        return String.format(deleteSql, entity.getTableName(), getWheres(entity.getWhereCols()));
    }

    /**
     * @param entity
     * @return
     * @throws SqlFormatException
     */
    public String getUpdateSql(SqlEntity<T> entity) throws SqlFormatException {
        String updateSql = "UPDATE %s SET %s WHERE 1 != 1 %s";
        StringBuilder updateValues = new StringBuilder();
        int i = 0;
        if (!entity.getValueCols().isEmpty()) {
            for (String col : entity.getValueCols()) {
                if (i == 0) {
                    updateValues.append(col + " = :" + convert2Camel(col));
                } else {
                    updateValues.append(", " + col + " = :" + convert2Camel(col));
                }
                ++i;
            }
        } else {
            throw new SqlFormatException(updateSql);
        }
        return String.format(updateSql, entity.getTableName(), updateValues, getWheres(entity.getWhereCols()));
    }


    /**
     * @param entity
     * @return
     * @throws SqlFormatException
     */
    public String getSelectSql(SqlEntity<T> entity) throws SqlFormatException {
        String selectSql = "SELECT %s FROM %s WHERE 1 != 1 %s";
        StringBuilder selectValues = new StringBuilder();
        if (!entity.getValueCols().isEmpty()) {
            int i = 0;
            for (String col : entity.getValueCols()) {
                if (i == 0) {
                    selectValues.append(col + " AS " + convert2Camel(col));
                } else {
                    selectValues.append(", ".concat(col) + " AS " + convert2Camel(col));
                }
                ++i;
            }
        } else {
            throw new SqlFormatException(selectSql);
        }
        return String.format(selectSql, selectValues, entity.getTableName(), getWheres(entity.getWhereCols()));
    }


    /**
     *
     * @param entity
     * @param page
     * @return
     * @throws SqlFormatException
     */
    public String getPageSelectSql(SqlEntity<T> entity, Page page) throws SqlFormatException {
        StringBuilder selectSql = new StringBuilder(getSelectSql(entity));
        if (null != page) {
            // limit 0, 10  其中，0 是索引，10 是记录数
            selectSql.append(" LIMIT ").append(page.getPageIndex()).append(", ").append(page.getPageSize());
        }
        return selectSql.toString();
    }


    /**
     * @param whereCols
     * @return
     */
    public String getWheres(List<String> whereCols) {
        StringBuilder whereValues = new StringBuilder();
        if (!whereCols.isEmpty()) {
            whereValues.append(" OR ( ");
            int i = 0;
            for (String col : whereCols) {
                if (i == 0) {
                    whereValues.append(col + " = :" + convert2Camel(col));
                } else {
                    whereValues.append(" AND " + col + " = :" + convert2Camel(col));
                }
                ++i;
            }
            whereValues.append(" )");
        }
        return whereValues.toString();
    }


    public static void main(String[] args) {
        String[] cols = {"abc_efg", "id_ip"};
        System.out.println(SingleFactory.SINGLE.getWheres(Lists.asList(String.class, cols)));
    }

}
