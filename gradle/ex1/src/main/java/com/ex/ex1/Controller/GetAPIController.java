package com.ex.ex1.Controller;

import com.ex.ex1.Domain.SearchVO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GetAPIController {

    @RequestMapping(path = "/getRequest", method = RequestMethod.GET)   // localhost:8080/api/getRequest
    public String getRequest() {
        return "this is getRequest";
    }

    @GetMapping("/getParameters")
    public String getParameters(@RequestParam("id") String id, @RequestParam("password") String pwd) {
        return "id: " + id + "/ pwd: " + pwd;
    }

    @GetMapping("/getMultiParameters")
    public String getMultiParameters(SearchVO searchVo) {
        return "VO사용 아이디는 "+ searchVo.getId() +" 이메일은 "+ searchVo.getEmail();
    }

    @GetMapping("/getMultiParametersRtnJson")
    public SearchVO getMultiParametersRtnJson(SearchVO searchVo) {
        return searchVo;
    }


}
