package com.jgm.module6;

import com.jgm.module6.entity.Event;
import com.jgm.module6.entity.Ticket;
import com.jgm.module6.entity.User;
import com.jgm.module6.facade.BookingFacade;
import com.jgm.module6.service.UserAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@TestPropertySource(
        locations = "classpath:application-test.properties")
@SpringBootTest
@AutoConfigureMockMvc
public class JmsControllerUnitTest2 {

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private MockMvc mvc;

    @MockBean
    UserAccountService accountService;

    @MockBean
    private BookingFacade booking;


    @Test
    public void bookTicketsTest() throws Exception {
        User user1 = new User(1L, "name1", "email1@gmail.com");
        Event event1 = new Event(1L, "title1", new Date(), 10.0);
        Ticket ticket = new Ticket(1L, Ticket.Category.STANDARD, 1, event1, user1);

        when(accountService.refillAccount(event1.getTicketPrice(), user1)).thenReturn(true);
        when(booking.getUserById(1L)).thenReturn(user1);
        when(booking.getEventById(1L)).thenReturn(event1);

        mvc.perform(post("http://localhost:8080/ticket/create?userId=1&eventId=1&place=1&category=STANDART"))
                .andExpect(status().isOk());
    }

}
