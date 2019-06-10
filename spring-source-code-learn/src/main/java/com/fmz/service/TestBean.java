package com.fmz.service;

import org.apache.log4j.Logger;

public class TestBean {

    private static final Logger logger = Logger.getLogger(TestBean.class);

    public void doSomething() {
        logger.debug("I am the testBean print log... DEBUG");
        logger.info("I am the testBean print log... INFO");
    }
}
