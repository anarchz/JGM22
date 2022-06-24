package com.jgm.module6.service;

import com.jgm.module6.entity.Event;
import com.jgm.module6.repository.EventRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class EventServiceTest {
    @InjectMocks
    EventService eventService;

    @Mock
    EventRepository eventRepository;

    @Test
    void getEventById() {
        Event event1 = new Event(1, "title1", new Date());
        Event event2 = new Event(2, "title2", new Date());
        List<Event> list = new ArrayList<>();
        list.add(event1);
        list.add(event2);

        when(eventRepository.findById(1L)).thenReturn(Optional.of(event1));

        Assertions.assertEquals(event1, eventService.getEventById(1L));
    }

    @Test
    void createEvent() {
        Event event1 = new Event(1, "title1", new Date());
        when(eventRepository.save(any())).thenReturn(event1);

        Assertions.assertEquals(event1, eventService.createEvent(event1));
    }

    @Test
    void updateEvent() {
        Event event1 = new Event(1, "title1", new Date());
        when(eventRepository.save(any())).thenReturn(event1);

        Assertions.assertEquals(event1, eventService.updateEvent(event1));
    }

    @Test
    void deleteEvent() {
        eventRepository.save(new Event(1L, "title1", new Date()));
        eventService.deleteEvent(1L);
        verify(eventRepository, times(1)).deleteById(1L);
    }
}