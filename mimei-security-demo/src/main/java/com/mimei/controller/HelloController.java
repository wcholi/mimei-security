package com.mimei.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuchongliang
 * @create 2019-08-13 12:50:37
 * @description:
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello spring security";
    }
}

