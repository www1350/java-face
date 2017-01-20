package com.absurd.adapter;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/***
 *
 */
public class AdapterTest {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Test
    public void adapterClassTest(){
        Adaptee adaptee = new Adapter();
        Target  target = (Adapter) adaptee;
        target.method1();
        target.method2();
    }

    @Test
    public void adapterObjTest(){
        Adaptee adaptee = new Adapter();
        AdapterObj adapterObj = new AdapterObj(adaptee);
        adapterObj.method1();
        adapterObj.method2();
    }
}
