package com.jgm.module6;

import com.jgm.module6.controller.TicketController;
import com.jgm.module6.entity.Event;
import com.jgm.module6.entity.Ticket;
import com.jgm.module6.entity.User;
import com.jgm.module6.facade.BookingFacade;
import com.jgm.module6.service.UserAccountService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class JmsControllerUnitTest1 {

    @Autowired
    private TicketController controller;

    @MockBean
    UserAccountService accountService;

    @MockBean
    private BookingFacade booking;

    @MockBean
    JmsTemplate jmsTemplate;

    @Test
    public void bookTicketsTest() {
        User user1 = new User(1L, "name1", "email1@gmail.com");
        Event event1 = new Event(1L, "title1", new Date(), 10.0);

        when(accountService.refillAccount(event1.getTicketPrice(), user1)).thenReturn(true);
        when(booking.getUserById(1L)).thenReturn(user1);
        when(booking.getEventById(1L)).thenReturn(event1);

        Assertions.assertTrue(controller.create(1L, 1L, 1, Ticket.Category.STANDARD));
    }
}
