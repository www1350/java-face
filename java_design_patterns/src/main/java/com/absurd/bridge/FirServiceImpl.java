package com.absurd.bridge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/****
 *
 */
public class FirServiceImpl implements Service{
    Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public void method1() {
        logger.info("fir");
    }
}
