package com.service;

import com.dao.TicketDAO;
import com.model.Event;
import com.model.Ticket;
import com.model.User;
import com.repository.TicketRepository;
import com.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    TicketRepository repository;
    @Autowired
    UserAccountRepository accountRepository;

    public TicketService() {
    }

    public Ticket bookTicket(long userId, long eventId, int place, Ticket.Category category, double amount) {
        Ticket ticket = new TicketDAO(userId, eventId, place, category);
        accountRepository.withdraw(amount, userId);
        return repository.save(ticket);
    }

    public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
        return repository.findAllByUser(user);
    }

    public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
        return repository.findAllByEvent(event);
    }

    public boolean cancelTicket(long ticketId, double amount, long userId) {
        accountRepository.refillAcc(amount, userId);
        repository.deleteById(ticketId);
        return false;
    }

}
