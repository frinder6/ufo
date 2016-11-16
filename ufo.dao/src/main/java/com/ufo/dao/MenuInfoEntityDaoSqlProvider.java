package com.ufo.dao;

import com.ufo.entity.MenuInfoEntity;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

/**
 * Created by frinder6 on 2016/11/15.
 */
public class MenuInfoEntityDaoSqlProvider {

    public String selectPageSql(MenuInfoEntity record) {
        BEGIN();
        SELECT("id,parent_id,title,url,icon,sort,status,create_time,creater,update_time,updater");
        FROM("ufo_menu_info");
        if (record.getParentId() != null) {
            WHERE("parent_id = #{parentId,jdbcType=BIGINT}");
        }

        if (record.getTitle() != null) {
            WHERE("title like '#{title,jdbcType=VARCHAR}%'");
        }

        if (record.getUrl() != null) {
            WHERE("url like '#{url,jdbcType=VARCHAR}%'");
        }

        if (record.getIcon() != null) {
            WHERE("icon like '#{icon,jdbcType=VARCHAR}%'");
        }

        if (record.getSort() != null) {
            WHERE("sort = #{sort,jdbcType=TINYINT}");
        }

        if (record.getStatus() != null) {
            WHERE("status = #{status,jdbcType=TINYINT}");
        }

        if (record.getCreateTime() != null) {
            WHERE("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }

        if (record.getCreater() != null) {
            WHERE("creater = #{creater,jdbcType=VARCHAR}");
        }

        if (record.getUpdateTime() != null) {
            WHERE("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }

        if (record.getUpdater() != null) {
            WHERE("updater = #{updater,jdbcType=VARCHAR}");
        }
        return SQL();
    }

    public String selectPageCtSql(MenuInfoEntity record) {
        BEGIN();
        SELECT("count(1)");
        FROM("ufo_menu_info");
        return SQL();
    }

}
