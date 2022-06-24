package com.jgm.module6.service;

import com.jgm.module6.entity.Event;
import com.jgm.module6.repository.EventRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class EventService {
    @Autowired
    EventRepository repository;

    public Event getEventById(long eventId) {
        return repository.findById(eventId).get();
    }

    public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        return repository.findAllByTitle(title, PageRequest.of(pageNum, pageSize));
    }

    public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
        return repository.findAllByDate(day, PageRequest.of(pageNum, pageSize));
    }

    @Transactional
    public Event createEvent(Event event) {
        log.info("event created" + event.getId());
        return repository.save(event);
    }

    @Transactional
    public Event updateEvent(Event event) {
        log.info("event updated" + event.getId());
        return repository.save(event);
    }

    @Transactional
    public boolean deleteEvent(long eventId) {
        repository.delete(getEventById(eventId));
        log.info("event deleted" + eventId);
        return true;
    }

}
