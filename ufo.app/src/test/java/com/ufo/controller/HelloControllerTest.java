package com.ufo.controller;

import com.ufo.base.Junit4Log4jClassRunner;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

/**
 * Created by on 2016/7/31.
 */

@RunWith(Junit4Log4jClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/app-servlet.xml",
        "file:src/main/webapp/WEB-INF/applicationContext.xml"})
public class HelloControllerTest {

    @Autowired
    private HelloController helloController;

    @Test
    public void hello() throws Exception {
        helloController.hello();
    }

}