package com.app.cv.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/hotel-ms/test")
    public String test() {
        return "Hotel service is working!";
    }
}
