package com.aljumaro.techtest.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
public class HelloController {

    @Value("${profile}")
    private String environment;

    @Value("${other}")
    private String other;

    @Value("${external}")
    private String external;

    @RequestMapping("/")
    public String index() {
        return "Hello Spring Boot from " + environment + other + external;
    }

}
