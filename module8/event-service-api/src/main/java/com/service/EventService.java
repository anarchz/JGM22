package com.service;

import com.dto.Event;

import java.util.List;

public interface EventService {
    Event createEvent(Event event);
    Event updateEvent(Event event);
    Event getEvent(Integer id);
    Event deleteEvent(Integer id);
    List<Event> getAllEvents();
    List<Event> getAllEventsByTitle(String title);
}
