package com.absurd.abstractfactory;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/***
 *
 */
public class AppTest {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Test
    public void appTest(){
        App app = new App();
        app.createApp(new FirstFactory());
        logger.info(app.getDesc());

        app.createApp(new SecFactory());
        logger.info(app.getDesc());
    }
}
