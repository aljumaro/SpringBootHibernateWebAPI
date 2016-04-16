package com.aljumaro.techtest.web;

import com.aljumaro.techtest.service.logging.EnvDependentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
@RequestMapping("/")
public class HelloController {

    @Autowired
    private EnvDependentService envDependentService;

    @RequestMapping
    public String index() {

        envDependentService.log("Hello");

        return "Hello Spring Boot from ";
    }

}
