package com.aljumaro.techtest.controller;

import com.aljumaro.techtest.entity.Message;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Hello Spring Boot";
    }

    @RequestMapping("/message")
    public Message getMessage(){
        Message m = new Message();

        m.setTitle("titulo");
        m.setText("Texto");

        return m;
    }
}
