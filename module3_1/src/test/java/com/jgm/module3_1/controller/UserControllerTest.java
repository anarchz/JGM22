package com.jgm.module3_1.controller;

import com.jgm.module3_1.entity.User;
import com.jgm.module3_1.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserControllerTest {

    private MockMvc mvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private UserRepository repository;

    @Before
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }

    @Test
    void getUser() throws Exception {
        repository.save(new User(1L, "name1", "email1@gmail.com"));
        mvc.perform(get("http://localhost:8080/user/byId?id=1")).andExpect(status().isOk());
    }

    @Test
    void delete() throws Exception {
        repository.save(new User(1L, "name1", "email1@gmail.com"));
        mvc.perform(get("http://localhost:8080/user/delete/1")).andExpect(status().isOk());
    }

    @Test
    void create() throws Exception {
        repository.save(new User(1L, "name1", "email1@gmail.com"));
        mvc.perform(get("http://localhost:8080/user/byId?id=1")).andExpect(status().isOk());
    }
}