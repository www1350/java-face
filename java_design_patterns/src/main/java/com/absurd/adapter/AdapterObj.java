package com.absurd.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/***
 *  对象适配器
 */
public class AdapterObj {
    Logger logger = LoggerFactory.getLogger(getClass());
    private Adaptee adaptee;
    public AdapterObj(Adaptee adaptee){
        this.adaptee = adaptee;
    }
    public void method1(){
        this.adaptee.method1();
    }
    public void method2(){
        logger.info("method2");

    }
}
