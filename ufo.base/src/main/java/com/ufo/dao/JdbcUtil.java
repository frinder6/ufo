package com.ufo.dao;

import com.google.common.base.CaseFormat;

/**
 * Created by frinder_liu on 2016/8/1.
 */
public class JdbcUtil {

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
     * @param tableName
     * @param cols
     * @return
     */
    public String getInsertSql(String tableName, String[] cols) {
        String insertSql = "INSERT INTO %s ( %s ) VALUES ( %s )";
        StringBuilder insertCols = new StringBuilder();
        StringBuilder insertValues = new StringBuilder();
        int i = 0;
        for (String col : cols) {
            if (i == 0) {
                insertCols.append(col);
                insertValues.append(":" + convert2Camel(col));
            } else {
                insertCols.append(", ".concat(col));
                insertValues.append(", :" + convert2Camel(col));
            }
            ++i;
        }
        return String.format(insertSql, tableName, insertCols, insertValues);
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
     * @param tableName
     * @param whereCols
     * @return
     */
    public String getWheresDeleteSql(String tableName, String[] whereCols) {
        String deleteSql = "DELETE FROM %s WHERE 1 = 1 %";
        return String.format(deleteSql, tableName, getWheres(whereCols));
    }

    /**
     * @param tableName
     * @param valueCols
     * @param whereCols
     * @return
     */
    public String getUpdateSql(String tableName, String[] valueCols, String[] whereCols) {
        String updateSql = "UPDATE %s SET %s WHERE 1 = 1 %s";
        StringBuilder updateValues = new StringBuilder();
        int i = 0;
        for (String col : valueCols) {
            if (i == 0) {
                updateValues.append(col + " = :" + convert2Camel(col));
            } else {
                updateValues.append(", " + col + " = :" + convert2Camel(col));
            }
            ++i;
        }
        return String.format(updateSql, tableName, updateValues, getWheres(whereCols));
    }


    /**
     * @param tableName
     * @param valueCols
     * @param whereCols
     * @return
     */
    public String getSelectSql(String tableName, String[] valueCols, String[] whereCols) {
        String selectSql = "SELECT %s FROM %s WHERE 1 = 1 %s";
        StringBuilder selectValues = new StringBuilder();
        int i = 0;
        for (String col : valueCols) {
            if (i == 0) {
                selectValues.append(col);
            } else {
                selectValues.append(", ".concat(col));
            }
            ++i;
        }
        return String.format(selectSql, selectValues, tableName, getWheres(whereCols));
    }


    /**
     * @param whereCols
     * @return
     */
    public String getWheres(String[] whereCols) {
        StringBuilder whereValues = new StringBuilder();
        int i = 0;
        for (String col : whereCols) {
            if (i == 0) {
                whereValues.append(col + " = :" + convert2Camel(col));
            } else {
                whereValues.append(" AND " + col + " = :" + convert2Camel(col));
            }
            ++i;
        }
        return whereValues.toString();
    }


    public static void main(String[] args) {
        String[] cols = {"abc_efg", "id_ip"};
        System.out.println(SingleFactory.SINGLE.getWheres(cols));
    }

}
