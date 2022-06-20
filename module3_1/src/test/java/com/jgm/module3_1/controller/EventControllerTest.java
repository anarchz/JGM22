package com.jgm.module3_1.controller;

import com.jgm.module3_1.entity.Event;
import com.jgm.module3_1.repository.EventRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class EventControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private EventRepository repository;

    @Test
    void getEvents() throws Exception {
        repository.save(new Event(1, "title1", new Date()));
        mvc.perform(get("http://localhost:8080/events/byTitle?title=title1"))
                .andExpect(status().isOk());
    }

    @Test
    void create() throws Exception {
        repository.save(new Event(1, "title1", new Date()));
        mvc.perform(get("http://localhost:8080/events/byTitle?title=title1"))
                .andExpect(status().isOk());
    }

    @Test
    void update() throws Exception {
        repository.save(new Event(1, "title1", new Date()));
        repository.save(new Event(1, "title2", new Date()));
        mvc.perform(get("http://localhost:8080/events/byTitle?title=title2"))
                .andExpect(status().isOk());
    }

    @Test
    void delete() throws Exception {
        repository.save(new Event(1, "title1", new Date()));
        repository.save(new Event(2, "title2", new Date()));
        mvc.perform(get("http://localhost:8080/events/delete/1"))
                .andExpect(status().isOk());
    }
}