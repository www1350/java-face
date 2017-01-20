package com.absurd.bridge;

import org.junit.Test;

/***
 *
 */
public class BridgeTest {

    @Test
    public void bridgeTest(){
        Bridge bridge = new MyBridge();
        bridge.setService(new FirServiceImpl());
        bridge.method1();
        bridge.setService(new SecServiceImpl());
        bridge.method1();

    }
}
