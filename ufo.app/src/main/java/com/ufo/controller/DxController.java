package com.ufo.controller;

import com.ufo.entity.DxDataEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public DxDataEntity dx(HttpServletRequest request) {
        DxDataEntity entity = new DxDataEntity();
        String posStr = request.getParameter("posStart");
        int pos = !StringUtils.isEmpty(posStr) ? Integer.parseInt(posStr) : 0;
        String countStr = request.getParameter("count");
        int count = !StringUtils.isEmpty(countStr) ? Integer.parseInt(countStr) : 10;
        entity.setTotal_count(DATA.size());
        entity.setPos(pos);
        List<Serializable> subList = DATA.subList(pos, pos + count);
        entity.setData(subList);
        return entity;
    }



}
