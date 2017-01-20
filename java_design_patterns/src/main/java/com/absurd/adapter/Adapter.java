package com.absurd.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/***
 *  类适配器
 */
public class Adapter extends Adaptee implements Target{
    Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public void method2() {
        logger.info("method2");
    }
}
