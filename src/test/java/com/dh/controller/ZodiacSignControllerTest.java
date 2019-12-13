package com.dh.controller;

import com.dh.StartApplication;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StartApplication.class)
public class ZodiacSignControllerTest {
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext context;
    @Before
    public void before() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }


    @Test
    public void getList() throws Exception {
        MockHttpServletRequestBuilder post = post("/api/zodiac/sign/json");
        ResultActions perform = mockMvc.perform(post.contentType(MediaType.APPLICATION_JSON));
        MockHttpServletResponse response = perform.andReturn().getResponse();
        System.err.println(response.getContentAsString());
    }


    @Test
    public void getListByParam() throws Exception {
        MockHttpServletRequestBuilder post = post("/api/zodiac/sign/param");
        Gson gson = new Gson();
        Map<String, Object> map = new HashMap<>();
        map.put("zodiacName", "鼠");
        String json = gson.toJson(map);
        ResultActions perform = mockMvc.perform(post.contentType(MediaType.APPLICATION_JSON).content(json));
        MockHttpServletResponse response = perform.andReturn().getResponse();
        System.err.println(response.getContentAsString());
    }
}