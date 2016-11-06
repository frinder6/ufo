package com.ufo.controller;

import com.ufo.entity.DxGridResult;
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
    public DxGridResult dx() {
        DxGridResult entity = new DxGridResult();
        List<Serializable> subList = DATA.subList(0, 1000);
        entity.setData(subList);
        return entity;
    }


}
