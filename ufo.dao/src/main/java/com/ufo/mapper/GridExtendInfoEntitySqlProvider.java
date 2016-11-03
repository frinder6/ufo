package com.ufo.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.ufo.entity.GridExtendInfoEntity;

public class GridExtendInfoEntitySqlProvider {

    public String insertSelective(GridExtendInfoEntity record) {
        BEGIN();
        INSERT_INTO("ufo_grid_extend_info");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getGridId() != null) {
            VALUES("grid_id", "#{gridId,jdbcType=BIGINT}");
        }
        
        if (record.getImagePath() != null) {
            VALUES("image_path", "#{imagePath,jdbcType=VARCHAR}");
        }
        
        if (record.getSkin() != null) {
            VALUES("skin", "#{skin,jdbcType=VARCHAR}");
        }
        
        if (record.getPagingSkin() != null) {
            VALUES("paging_skin", "#{pagingSkin,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            VALUES("status", "#{status,jdbcType=TINYINT}");
        }
        
        if (record.getCreateTime() != null) {
            VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreater() != null) {
            VALUES("creater", "#{creater,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateTime() != null) {
            VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdater() != null) {
            VALUES("updater", "#{updater,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(GridExtendInfoEntity record) {
        BEGIN();
        UPDATE("ufo_grid_extend_info");
        
        if (record.getGridId() != null) {
            SET("grid_id = #{gridId,jdbcType=BIGINT}");
        }
        
        if (record.getImagePath() != null) {
            SET("image_path = #{imagePath,jdbcType=VARCHAR}");
        }
        
        if (record.getSkin() != null) {
            SET("skin = #{skin,jdbcType=VARCHAR}");
        }
        
        if (record.getPagingSkin() != null) {
            SET("paging_skin = #{pagingSkin,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            SET("status = #{status,jdbcType=TINYINT}");
        }
        
        if (record.getCreateTime() != null) {
            SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreater() != null) {
            SET("creater = #{creater,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdater() != null) {
            SET("updater = #{updater,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }
}