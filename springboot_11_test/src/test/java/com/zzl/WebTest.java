package com.zzl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.HeaderResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

//SpringBootTest.WebEnvironment.NONE
//SpringBootTest.WebEnvironment.DEFINED_PORT
//SpringBootTest.WebEnvironment.MOCK
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

//开启虚拟MVC调用
@AutoConfigureMockMvc
public class WebTest {

//    @Autowired
//    private MockMvc mvc;


    @Test
    public void testStatus(@Autowired MockMvc mvc) {
        System.out.println("success");

//        创建了一个虚拟请求
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/zzl");
        try {
            //执行请求
            ResultActions resultActions = mvc.perform(builder);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testBody(@Autowired MockMvc mvc) throws Exception {

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/zzl");
        ResultActions resultActions = mvc.perform(builder);
        //设置预期值与真实结果进行比较，测试方法

//        定义本次调用的预期值
        ContentResultMatchers content = MockMvcResultMatchers.content();
//        预计本次状态是成功的
        ResultMatcher springboot = content.string("springboot");

        //添加预期值到本次过程进行匹配
        resultActions.andExpect(springboot);
    }


    @Test
    public void testJson(@Autowired MockMvc mvc) throws Exception {

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/zzl");
        ResultActions resultActions = mvc.perform(builder);
        //设置预期值与真实结果进行比较，测试方法

//        定义本次调用的预期值
        ContentResultMatchers content = MockMvcResultMatchers.content();
//        预计本次状态是成功的
        ResultMatcher springboot = content.json("{\"id\":1,\"name\":\"zzl\",\"type\":\"奢靡\",\"description\":\"sssssssssssss\"}");

        //添加预期值到本次过程进行匹配
        resultActions.andExpect(springboot);
    }


    @Test
    public void testContent(@Autowired MockMvc mvc) throws Exception {

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/zzl");
        ResultActions resultActions = mvc.perform(builder);
        //设置预期值与真实结果进行比较，测试方法

//        定义本次调用的预期值
        HeaderResultMatchers header = MockMvcResultMatchers.header();
//        预计本次状态是成功的

        ResultMatcher string = header.string("Content-Type", "application/json");
//        //添加预期值到本次过程进行匹配
        resultActions.andExpect(string);
    }
}
