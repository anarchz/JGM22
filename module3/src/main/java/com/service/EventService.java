package com.service;

import com.model.Event;
import com.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EventService {
    @Autowired
    EventRepository repository;

    public EventService() {
    }

    public Event getEventById(long eventId) {
        return repository.findById(eventId);
    }

    public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        return repository.findAllByTitle(title);
    }

    public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
        return repository.findAllByDate(day);
    }

    public Event createEvent(Event event) {
        return repository.save(event);
    }

    public Event updateEvent(Event event) {
        return repository.save(event);
    }

    public boolean deleteEvent(long eventId) {
        repository.delete(getEventById(eventId));
        return true;
    }

}
