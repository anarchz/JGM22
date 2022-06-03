package com.service;

import com.dao.Storage;
import com.dao.TicketDAO;
import com.model.Event;
import com.model.Ticket;
import com.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import com.model.Ticket.Category.*;

@Service
public class TicketService {

    List<Ticket> tickets;
    private Map<String, List<?>> storage;

    public TicketService() {
        tickets = new ArrayList<Ticket>();
        storage = Storage.getStorage();
        storage.put("ticket", tickets);
    }

    public Ticket bookTicket(long userId, long eventId, int place, Ticket.Category category) {
        for (Ticket ticket : tickets) {
            if (ticket.getPlace() == place) {
                throw new IllegalStateException("Already reserved place");
            }
        }
        Ticket ticket = new TicketDAO(userId, eventId, place, category);
        tickets.add(ticket);
        return ticket;
    }

    public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
        List<Ticket> bookedTickets = new ArrayList<Ticket>();
        for(Ticket ticket : tickets) {
            if (ticket.getUserId()== user.getId()) {
                bookedTickets.add(ticket);
            }
        }
        int startIndex = bookedTickets.size()/pageSize*pageNum-1;
        return bookedTickets.subList(startIndex, startIndex+pageSize);
    }

    public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
        List<Ticket> bookedTickets = new ArrayList<Ticket>();
        for(Ticket ticket : tickets) {
            if (ticket.getEventId()== event.getId()) {
                bookedTickets.add(ticket);
            }
        }
        int startIndex = bookedTickets.size()/pageSize*pageNum-1;
        return bookedTickets.subList(startIndex, startIndex+pageSize);
    }

    public boolean cancelTicket(long ticketId) {
        Iterator<Ticket> iterator = tickets.iterator();
        while (iterator.hasNext()) {
            if(iterator.next().getId() == ticketId) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

}
