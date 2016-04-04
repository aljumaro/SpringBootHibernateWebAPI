package com.aljumaro.techtest.service.logging.dev;

import com.aljumaro.techtest.service.logging.EnvDependentService;

/**
 * @Date 03/04/2016
 * @Time 10:34
 * @Author Juanma
 */
public class EnvDependentServiceDevImpl implements EnvDependentService {

    public void log(String message) {
        System.out.println("dev: " + message);
    }
}
