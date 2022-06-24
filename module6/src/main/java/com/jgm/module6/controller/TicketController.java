package com.jgm.module6.controller;

import com.jgm.module6.entity.Event;
import com.jgm.module6.entity.Ticket;
import com.jgm.module6.entity.User;
import com.jgm.module6.facade.BookingFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TicketController {
    @Autowired
    private BookingFacade booking;

    @GetMapping("/ticket/delete/{id}")
    public Boolean delete(@PathVariable("id") Long id) {
        return booking.cancelTicket(id);
    }

    @GetMapping("/ticket/byEvent")
    public List<Ticket> getBookedTickets(@RequestBody Event event) {
        return booking.getBookedTickets(event,5,0);
    }

    @GetMapping("/ticket")
    public List<Ticket> getBookedTicketsForUser(@RequestBody User user) {
        return booking.getBookedTickets(user,5,0);
    }

    @PostMapping("/ticket/create")
    public Ticket create(@RequestParam Long userId, @RequestParam Long eventId, @RequestParam Integer place, @RequestParam Ticket.Category category){
        return booking.bookTicket(booking.getUserById(userId), booking.getEventById(eventId), place, category);
    }
}
