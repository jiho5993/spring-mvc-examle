package com.ex.ex1.Controller;

import com.ex.ex1.Domain.SearchVO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PostAPIController {

    @RequestMapping(path = "/postRequest", method = RequestMethod.POST)
    public SearchVO postRequest(@RequestBody SearchVO searchVO) {
        return searchVO;
    }

    @PostMapping(value = "/postMapping")
    public SearchVO postMapping(@RequestBody SearchVO searchVo){
        return searchVo;
    }

}
