package com.ufo.controller;

import com.ufo.entity.DictInfoEntity;
import com.ufo.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by frinder6 on 2016/10/24.
 */
@RequestMapping("/dict")
@RestController
public class DictController {

    @Autowired
    private DictService dictService;

    @RequestMapping("/get.dict")
    public List<DictInfoEntity> dict(@RequestParam("name") String name) {
        return dictService.selectByName(name);
    }

}
