package com.ufo;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by frinder6 on 2017/1/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BaseTest {

    protected MockMvc mvc;

    @Autowired
    protected WebApplicationContext webApplicationConnect;

    @Before
    public void setUp() throws JsonProcessingException {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationConnect).build();
    }

}
