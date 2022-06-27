package com.jgm.module6.facade;

import com.jgm.module6.entity.BookingMessage;
import com.jgm.module6.entity.Event;
import com.jgm.module6.entity.Ticket;
import com.jgm.module6.entity.User;
import com.jgm.module6.service.EventService;
import com.jgm.module6.service.TicketService;
import com.jgm.module6.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class BookingFacadeImpl implements BookingFacade {
    @Autowired
    private EventService eventService;
    @Autowired
    private TicketService ticketService;
    @Autowired
    private UserService userService;
    @Autowired
    private JmsTemplate jmsTemplate;

    public Event getEventById(long eventId) {
        return eventService.getEventById(eventId);
    }

    public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        return eventService.getEventsByTitle(title,pageSize,pageNum);
    }

    public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
        return eventService.getEventsForDay(day,pageSize,pageNum);
    }

    public Event createEvent(Event event) {
        return eventService.createEvent(event);
    }

    public Event updateEvent(Event event) {
        return eventService.updateEvent(event);
    }

    public boolean deleteEvent(long eventId) {
        return eventService.deleteEvent(eventId);
    }

    public User getUserById(long userId) {
        return userService.getUserById(userId);
    }

    public User getUserByEmail(String email) {
        return userService.getUserByEmail(email);
    }

    public List<User> getUsersByName(String name, int pageSize, int pageNum) {
        return userService.getUsersByName(name, pageSize, pageNum);
    }

    public User createUser(User user) {
        return userService.createUser(user);
    }

    public User updateUser(User user) {
        return userService.updateUser(user);
    }

    public boolean deleteUser(long userId) {
        return userService.deleteUser(userId);
    }

    public void bookTicket(User userId, Event eventId, int place, Ticket.Category category) {
        BookingMessage message = new BookingMessage(userId, eventId, place, category);

        jmsTemplate.convertAndSend("bookingQueue", message);
    }

    public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
        return ticketService.getBookedTickets(user, pageSize, pageNum);
    }

    public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
        return ticketService.getBookedTickets(event, pageSize, pageNum);
    }

    public boolean cancelTicket(long ticketId) {
        return ticketService.cancelTicket(ticketId);
    }
}
