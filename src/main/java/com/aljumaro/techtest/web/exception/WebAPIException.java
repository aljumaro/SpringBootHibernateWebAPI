package com.aljumaro.techtest.web.exception;

import org.springframework.http.HttpStatus;

/**
 * @Date 21/05/2016
 * @Time 10:43
 * @Author Juanma
 */
public class WebAPIException extends RuntimeException {

    private HttpStatus status;

    public WebAPIException(HttpStatus status){
        status = status;
    }
}
