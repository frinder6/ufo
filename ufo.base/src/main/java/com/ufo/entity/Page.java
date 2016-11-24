package com.ufo.entity;

import com.google.common.base.CaseFormat;
import lombok.Data;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by frinder_liu on 2016/8/13.
 */

@Data
public class Page {

    public Page(int pageIndex, int pageSize, String sort, String order) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.sort = sort;
        this.order = order;
        pageFrom = (pageIndex > 0 ? (pageIndex - 1) : 0) * pageSize;
    }

    private int pageIndex = 1;
    private int pageSize = 20;
    private int pageFrom = 0;
    private String sort = "id";
    private String order = "ASC";


    /**
     * 将request转换为page对象
     *
     * @param request
     * @return
     */
    public static Page getInstance(HttpServletRequest request) {
        String pageStr = request.getParameter("page");
        int pageIndex = StringUtils.isEmpty(pageStr) ? 1 : Integer.parseInt(pageStr);
        String rowsStr = request.getParameter("rows");
        int pageSize = StringUtils.isEmpty(rowsStr) ? 20 : Integer.parseInt(rowsStr);
        String sortStr = request.getParameter("sort");
        String sort = StringUtils.isEmpty(sortStr) ? "id" : CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, sortStr);
        String orderStr = request.getParameter("order");
        String order = StringUtils.isEmpty(orderStr) ? "asc" : orderStr;
        Page page = new Page(pageIndex, pageSize, sort, order);
        return page;
    }

}
