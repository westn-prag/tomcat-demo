package com.pragmatics;

import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World!! You are seeing this only because I TRUST YOU!!!";
    }
}