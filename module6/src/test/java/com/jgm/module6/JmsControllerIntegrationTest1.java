package com.jgm.module6;

import com.jgm.module6.controller.TicketController;
import com.jgm.module6.entity.Event;
import com.jgm.module6.entity.Ticket;
import com.jgm.module6.entity.User;
import com.jgm.module6.repository.EventRepository;
import com.jgm.module6.repository.TicketRepository;
import com.jgm.module6.repository.UserRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class JmsControllerIntegrationTest1 {

    @Autowired
    private TicketController controller;

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    JmsTemplate jmsTemplate;

    @Test
    public void bookTicketsTest() {
        User user1 = new User(1L, "name1", "email1@gmail.com");
        Event event1 = new Event(1L, "title1", new Date(), 10.0);
        Ticket ticket = new Ticket(1L, Ticket.Category.STANDARD, 1, event1, user1);

        eventRepository.save(event1);
        userRepository.save(user1);

        controller.create(1L, 1L, 1, Ticket.Category.STANDARD);

        Ticket savedTicket = ticketRepository.findById(1L).get();

        System.out.println(savedTicket);
        Assertions.assertEquals(savedTicket, ticket);
    }


}
