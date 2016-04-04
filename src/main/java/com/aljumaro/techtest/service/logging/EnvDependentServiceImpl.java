package com.aljumaro.techtest.service.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Date 03/04/2016
 * @Time 10:45
 * @Author Juanma
 */
public class EnvDependentServiceImpl implements EnvDependentService {

    static final Logger LOG = LoggerFactory.getLogger(EnvDependentServiceImpl.class);

    public void log(String message) {
        LOG.info("default: " + message);
    }

}
