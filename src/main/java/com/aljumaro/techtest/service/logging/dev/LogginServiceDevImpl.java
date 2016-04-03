package com.aljumaro.techtest.service.logging.dev;

import com.aljumaro.techtest.service.logging.LogginService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @Date 03/04/2016
 * @Time 10:34
 * @Author Juanma
 */
public class LogginServiceDevImpl implements LogginService{

    public void log(String message) {
        System.out.println("dev: " + message);
    }
}
