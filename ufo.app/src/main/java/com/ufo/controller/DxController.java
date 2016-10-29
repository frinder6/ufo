package com.ufo.controller;

import com.ufo.entity.DtDataEntity;
import com.ufo.entity.DxDataEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by frinder6 on 2016/10/24.
 */
@RequestMapping("/dx")
@RestController
public class DxController {

    public static List<Serializable> DATA = new ArrayList() {{
        for (int i = 1; i <= 1000; i++) {
            int index = i;
            Map<String, Object> map = new HashMap() {{
                put("id", index);
                put("name", "name" + index);
                put("age", 27 + index % 9);
            }};
            add(map);
        }
    }};


    @RequestMapping("/dx.load")
    public DxDataEntity dx(@RequestParam("pos") int pos) {
        DxDataEntity entity = new DxDataEntity();
        int s = (pos - 1) * 10;
        int e = pos * 10;
        entity.setTotal_count(DATA.size());
        entity.setPos(pos);
        entity.setData(DATA.subList(s, e));
        return entity;
    }

    @RequestMapping("/dt.load")
    public DtDataEntity dt(HttpServletRequest request) {
        int start = Integer.parseInt(request.getParameter("start"));
        int len = Integer.parseInt(request.getParameter("length"));
        String pageNum = request.getParameter("pageNum");
        if (!StringUtils.isEmpty(pageNum)){
            start = Integer.parseInt(pageNum) * len;
        }
        DtDataEntity entity = new DtDataEntity();
        entity.setStart(start);
        entity.setRecordsFiltered(DATA.size());
        entity.setRecordsTotal(DATA.size());
        entity.setData(DATA.subList(start, start + len));
        return entity;
    }


}
