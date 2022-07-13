package com.service;

import com.dto.Event;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EventServiceImpl implements EventService {

    private final Map<Integer, Event> events = new HashMap<>();

    public EventServiceImpl() {
        events.put(1, new Event(1,"title1",1,"speaker1","type1", LocalDateTime.now()));
        events.put(2, new Event(2,"title2",2,"speaker2","type2", LocalDateTime.now()));
        events.put(3, new Event(3,"title3",3,"speaker3","type3", LocalDateTime.now()));
    }

    @Override
    public Event createEvent(Event event) {
        return events.put(event.getId(), event);
    }

    @Override
    public Event updateEvent(Event event) {
        return events.put(event.getId(), event);
    }

    @Override
    public Event getEvent(Integer id) {
        return events.get(id);
    }

    @Override
    public Event deleteEvent(Integer id) {
        return events.remove(id);
    }

    @Override
    public List<Event> getAllEvents() {
        return new ArrayList<>(events.values());
    }

    @Override
    public List<Event> getAllEventsByTitle(String title) {
        List<Event> eventsByTitle = new ArrayList<>();
        for(Map.Entry<Integer, Event> entry : events.entrySet()) {
            Event event = entry.getValue();
            if(event.getTitle().equals(title)) {
                eventsByTitle.add(event);
            }
        }
        return eventsByTitle;
    }
}
