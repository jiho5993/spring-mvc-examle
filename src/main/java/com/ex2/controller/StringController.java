package com.ex2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StringController {

    @RequestMapping("/doC")
    public String doC(@ModelAttribute("msg") String msg) {
        System.out.println("/doC called... " + msg);
        return "result";
    }
}
