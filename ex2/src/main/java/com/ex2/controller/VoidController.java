package com.ex2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VoidController {

    @RequestMapping("/doA")
    public void doA() {
        System.out.println("/doA called...");
    }

    @RequestMapping("/doB")
    public void doB() {
        System.out.println("/doB called...");
    }

}
