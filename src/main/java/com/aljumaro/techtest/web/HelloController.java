package com.aljumaro.techtest.web;

import com.aljumaro.techtest.service.logging.LogginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
public class HelloController {

    @Autowired
    private LogginService logginService;

    @RequestMapping("/")
    public String index() {

        logginService.log("Hello");

        return "Hello Spring Boot from ";
    }

}
