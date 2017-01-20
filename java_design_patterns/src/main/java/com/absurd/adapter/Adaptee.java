package com.absurd.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/***
 *
 */
public class Adaptee {
    Logger logger = LoggerFactory.getLogger(getClass());
    public void method1(){
        logger.info("method1");
    }
}
