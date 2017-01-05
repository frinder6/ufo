package com.ufo.controller;

import com.ufo.BaseTest;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Created by frinder6 on 2017/1/5.
 */
public class RedirectControllerTest extends BaseTest {

    @Test
    public void redirect() throws Exception {
        String uri = "/redirect/content/menu-info";
        String responseStr = mvc.perform(MockMvcRequestBuilders
                .post(uri, "json")
                .accept(MediaType.APPLICATION_JSON)
        )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        System.out.println(responseStr);
    }

}