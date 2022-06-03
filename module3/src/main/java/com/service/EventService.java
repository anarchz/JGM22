package com.service;

import com.dao.EventDAO;
import com.dao.Storage;
import com.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EventService {

    private final List<Event> events;
    private Map<String, List<?>> storage;

    public EventService() {
        events = new ArrayList<Event>();
        storage = Storage.getStorage();
        storage.put("event", events);
    }

    public Event getEventById(long eventId) {
        for(Event event : events) {
            if (event.getId() == eventId) {
                return event;
            }
        }
        return null;
    }

    public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        List<Event> eventsByTitle = new ArrayList<Event>();
        for(Event event : events) {
            if (event.getTitle().equals(title)) {
                eventsByTitle.add(event);
            }
        }
        int startIndex = eventsByTitle.size()/pageSize*pageNum -1;
        return eventsByTitle.subList(startIndex, startIndex+pageSize);
    }

    public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
        List<Event> eventsByDay = new ArrayList<Event>();
        for(Event event : events) {
            if (event.getDate().equals(day)) {
                eventsByDay.add(event);
            }
        }
        int startIndex = eventsByDay.size()/pageSize*pageNum - 1;
        return eventsByDay.subList(startIndex, startIndex+pageSize);
    }

    public Event createEvent(Event event) {
        Event createdEvent = new EventDAO(event.getId(), event.getTitle(), event.getDate());
        events.add(createdEvent);
        return createdEvent;
    }

    public Event updateEvent(Event event) {
        Event updatedEvent = new EventDAO(event.getId(), event.getTitle(), event.getDate());
        for(Event event1 : events){
            if(event.getId() == event1.getId()) {
                events.set(events.indexOf(getEventById(event.getId())), updatedEvent);
            }
        }
        return updatedEvent;
    }

    public boolean deleteEvent(long eventId) {
        Iterator<Event> iterator = events.iterator();
        while (iterator.hasNext()) {
            if(iterator.next().getId() == eventId) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

}
