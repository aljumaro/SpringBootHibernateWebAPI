package com.aljumaro.techtest.service.logging;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @Date 03/04/2016
 * @Time 10:45
 * @Author Juanma
 */
public class LogginServiceImpl implements LogginService {

    public void log(String message) {
        System.out.println("default: " + message);
    }

}
