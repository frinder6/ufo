package com.ufo.entity;

import lombok.Data;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by frinder6 on 2016/10/24.
 */
@Data
public class DxDataEntity implements Serializable {

    public DxDataEntity() {
    }

    private long gridId;

    private String cols;

    private int total_count;

    private int pos;

    private int size;

    private int from;

    private int to;

    private Object data;

    private List<GridRow> rows;

    public int getFrom() {
        from = pos;
        return from;
    }

    public int getTo() {
        to = pos + size;
        return this.to;
    }


    /**
     * 获取 DxDataEntity
     *
     * @param request
     * @return
     */
    public static DxDataEntity getInstance(HttpServletRequest request) {
        DxDataEntity entity = new DxDataEntity();
        String posStr = request.getParameter("posStart");
        int pos = !StringUtils.isEmpty(posStr) ? Integer.parseInt(posStr) : 0;
        String countStr = request.getParameter("count");
        int count = !StringUtils.isEmpty(countStr) ? Integer.parseInt(countStr) : 10;
        String gridIdStr = request.getParameter("gridId");
        int gridId = !StringUtils.isEmpty(gridIdStr) ? Integer.parseInt(gridIdStr) : 0;
        entity.setPos(pos);
        entity.setSize(count);
        entity.setGridId(gridId);
        return entity;
    }

}
