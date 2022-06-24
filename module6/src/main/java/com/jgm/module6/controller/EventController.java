package com.jgm.module6.controller;

import com.jgm.module6.entity.Event;
import com.jgm.module6.facade.BookingFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class EventController {
    @Autowired
    private BookingFacade booking;

    @GetMapping("/events/byTitle")
    public List<Event> getEventsBy(@RequestParam String title) {
        return booking.getEventsByTitle(title,5, 1);
    }

    @PostMapping("/events/create")
    public Event create(@RequestBody Event event){
        return booking.createEvent(event);
    }

    @PostMapping("/events/update/{id}")
    public Event update(@PathVariable("id") Long id, @RequestBody Event event){
        return booking.updateEvent(event);
    }

    @GetMapping("/events/byDay")
    public List<Event> getEvents(@RequestParam("day") Date day) {
        return booking.getEventsForDay(day,5, 1);
    }

    @GetMapping("/events/delete/{id}")
    public Boolean delete(@PathVariable("id") Long id) {
        return booking.deleteEvent(id);
    }
}
