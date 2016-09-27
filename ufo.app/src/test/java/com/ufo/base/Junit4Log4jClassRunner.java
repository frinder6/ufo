package com.ufo.base;

import org.junit.runners.model.InitializationError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created on 2016/7/31.
 */
public class Junit4Log4jClassRunner extends SpringJUnit4ClassRunner {

    private static final Logger logger = LoggerFactory.getLogger(Junit4Log4jClassRunner.class);

//    static {
//        try {
//             LogbackConfigurer.initLogging("file:src/main/webapp/WEB-INF/logback.xml");
//        } catch (FileNotFoundException e) {
//            logger.error(e.getMessage());
//        } catch (JoranException e) {
//            e.printStackTrace();
//        }
//    }


    public Junit4Log4jClassRunner(Class<?> clazz) throws InitializationError {
        super(clazz);
    }

}
