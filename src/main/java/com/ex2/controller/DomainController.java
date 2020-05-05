package com.ex2.controller;

import com.ex2.domain.ProductVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DomainController {

    @RequestMapping("/doD")
    public String doD(Model model) {
        ProductVO product = new ProductVO("desktop", 10000);
        System.out.println("/doD called...");
        model.addAttribute(product);

        return "productDetail";
    }
}
