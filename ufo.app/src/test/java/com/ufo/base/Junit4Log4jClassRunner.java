package com.ufo.base;

import org.apache.log4j.Logger;
import org.junit.runners.model.InitializationError;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Log4jConfigurer;

import java.io.FileNotFoundException;

/**
 * Created on 2016/7/31.
 */
public class Junit4Log4jClassRunner extends SpringJUnit4ClassRunner {

    private static final Logger logger = Logger.getLogger(Junit4Log4jClassRunner.class);

    static {
        try {
            Log4jConfigurer.initLogging("file:src/main/webapp/WEB-INF/log4j.properties");
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage());
        }
    }


    public Junit4Log4jClassRunner(Class<?> clazz) throws InitializationError {
        super(clazz);
    }

}
