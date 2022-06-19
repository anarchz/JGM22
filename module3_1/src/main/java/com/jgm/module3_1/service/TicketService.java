package com.jgm.module3_1.service;

import com.jgm.module3_1.entity.Event;
import com.jgm.module3_1.entity.Ticket;
import com.jgm.module3_1.entity.User;
import com.jgm.module3_1.repository.TicketRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
public class TicketService {
    @Autowired
    TicketRepository repository;
    @Autowired
    UserAccountService accountService;

    @Transactional
    public Ticket bookTicket(User userId, Event eventId, int place, Ticket.Category category) {
        Ticket ticket = new Ticket(userId, eventId, place, category);
        accountService.refillAccount(eventId.getTicketPrice(), userId);
        log.info("ticket booked {}, {}, {}, {}", userId.getId(), eventId, place, category);
        return repository.save(ticket);
    }

    public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
        return repository.findAllByTicketUser(user, PageRequest.of(pageNum, pageSize));
    }

    public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
        return repository.findAllByEvent(event, PageRequest.of(pageNum, pageSize));
    }

    @Transactional
    public boolean cancelTicket(long ticketId) {
        Ticket ticket = repository.findById(ticketId).get();
        accountService.returnMoney(ticket.getEvent().getTicketPrice(), ticket.getTicketUser());
        repository.deleteById(ticketId);
        log.info("ticket canceled" + ticketId);
        return false;
    }

}
