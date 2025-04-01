package com.hairsaloon.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping
    public  String HomeControllerHandler(){

        return "User Home Controller Microservices";
    }

}
