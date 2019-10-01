package com.jungle.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

/**
 * Created by jungle on 2019/2/23.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BoyControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test//对API的测试
    public void boyList() throws Exception {
    mvc.perform(MockMvcRequestBuilders.get("/boys"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect((MockMvcResultMatchers.content().string("abc")));
    }

}