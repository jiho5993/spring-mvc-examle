package com.ex2;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.inject.Inject;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/*.xml"})
public class ControllerTest {

    @Inject
    private WebApplicationContext webApplicationContext;

    // 브라우저에서 요청과 응답을 의미하는 객체
    private MockMvc mockMvc;

    @Before // 테스트를 진행하기전 수행하는 작업
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
        System.out.println("setup...");
    }

    // 각각의 Controller 테스트 코드 작성
    @Test
    public void testDoA() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/doA"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testDoB() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/doB"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testDoC() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/doC?msg=Hello"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testDoD() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/doD"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("productVO"));
    }

    @Test
    public void testDoE() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/doE"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/doF?msg=this+is+the+message+with+redirected"));
    }

    @Test
    public void testDoJson() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/doJson"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=utf-8"));
    }

}
