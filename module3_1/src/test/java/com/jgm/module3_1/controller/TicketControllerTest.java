package com.jgm.module3_1.controller;

import com.jgm.module3_1.entity.Event;
import com.jgm.module3_1.entity.Ticket;
import com.jgm.module3_1.entity.User;
import com.jgm.module3_1.repository.TicketRepository;
import com.jgm.module3_1.repository.UserRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class TicketControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private TicketRepository repository;

    @Test
    void delete() throws Exception {
        User user1 = new User(1L, "name1", "email1@gmail.com");
        Event event1 = new Event(1L, "title1", new Date(), 10.0);
        Ticket ticket = new Ticket(1L, Ticket.Category.STANDARD, 1, event1, user1);

        repository.save(ticket);
        mvc.perform(get("http://localhost:8080/ticket/delete/1"))
                .andExpect(status().isOk());
    }

    @Test
    void create() throws Exception {
        mvc.perform(get("http://localhost:8080/ticket/create?userId=1&eventId=1&place=1&category=STANDART"))
                .andExpect(status().isOk());
    }
}