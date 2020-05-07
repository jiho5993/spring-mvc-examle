package com.ex2.controller;

import com.ex2.domain.ProductVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JsonController {

    @RequestMapping("/doJson")
    @ResponseBody
    public ProductVO doJson() {
        ProductVO p1 = new ProductVO("laptop", 500000);
        return p1;
    }
}
