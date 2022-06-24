package com.jgm.module6.service;

import com.jgm.module6.entity.Event;
import com.jgm.module6.entity.Ticket;
import com.jgm.module6.entity.User;
import com.jgm.module6.repository.TicketRepository;
import com.jgm.module6.repository.UserAccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class TicketServiceTest {

    @InjectMocks
    TicketService service;

    @Mock
    TicketRepository repository;

    @InjectMocks
    UserAccountService accountService;

    @Mock
    UserAccountRepository accountRepository;

    @Test
    void bookTicket() {
        User user1 = new User(1L, "name1", "email1@gmail.com");
        Event event1 = new Event(1, "title1", new Date(), 10.0);
        Ticket ticket = new Ticket(1L, Ticket.Category.STANDARD, 1, event1, user1);

        when(accountRepository.refillAcc(any(), 1L)).thenReturn(true);
        when(accountService.refillAccount(any(), user1)).thenReturn(true);

        when(repository.save(ticket)).thenReturn(ticket);

        Assertions.assertEquals(ticket, service.bookTicket(user1, event1, 1, Ticket.Category.STANDARD));
    }

    @Test
    void cancelTicket() {
        User user1 = new User(1L, "name1", "email1@gmail.com");
        Event event1 = new Event(1, "title1", new Date(), 10.0);
        Ticket ticket = new Ticket(1L, Ticket.Category.STANDARD, 1, event1, user1);

        when(accountRepository.withdraw(any(), 1L)).thenReturn(true);
        when(accountService.returnMoney(any(),user1)).thenReturn(true);

        Assertions.assertEquals(true, service.cancelTicket(1L));

    }
}