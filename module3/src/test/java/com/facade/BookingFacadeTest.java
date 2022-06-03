package com.facade;

import com.dao.EventDAO;
import com.dao.Storage;
import com.dao.UserDAO;
import com.model.Event;
import com.model.User;
import com.service.EventService;
import com.service.TicketService;
import com.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations={"/bean-config.xml"})
class BookingFacadeTest {
    @Autowired
    UserService userService;
    @Autowired
    EventService eventService;
    @Autowired
    TicketService ticketService;

    Map<String, List<?>> storage = Storage.getStorage();

    @BeforeTestMethod
    void before() {
        storage.clear();
    }

    @Test
    void getEventById() {
        Event event = eventService.createEvent(new EventDAO(1,"title", new Date()));
        Assertions.assertEquals(eventService.getEventById(1), event);
    }

    @Test
    void getEventsByTitle() {
        Event event = eventService.createEvent(new EventDAO(1,"title", new Date()));
        List<Event> list = new ArrayList<>();
        list.add(event);
        Assertions.assertEquals(eventService.getEventsByTitle("title", 1, 1), list);
    }

    @Test
    void getEventsForDay() {
        Event event = eventService.createEvent(new EventDAO(1,"title", new Date(2022,01,01)));
        List<Event> list = new ArrayList<>();
        list.add(event);
        Assertions.assertEquals(eventService.getEventsForDay(new Date(2022,01,01), 1, 1), list);

    }

    @Test
    void createEvent() {
        Event event = eventService.createEvent(new EventDAO(1,"title", new Date()));
        Assertions.assertEquals(eventService.getEventById(1), event);
    }

    @Test
    void updateEvent() {
        Event event = eventService.createEvent(new EventDAO(1,"title", new Date()));
        eventService.updateEvent(new EventDAO(1,"title1", new Date()));
        Assertions.assertEquals(eventService.getEventById(1).getTitle(), "title1");
    }

    @Test
    void deleteEvent() {
        Event event = eventService.createEvent(new EventDAO(1,"title", new Date()));
        eventService.deleteEvent(1);
        Assertions.assertEquals(null, eventService.getEventById(1));
    }

    @Test
    void getUserById() {
        User user = userService.createUser(new UserDAO(1, "name", "mail"));
        Assertions.assertEquals(userService.getUserById(1), user);
    }

    @Test
    void getUserByEmail() {
        System.out.println(storage);
        User user = userService.createUser(new UserDAO(1, "name", "mail"));
        Assertions.assertEquals(userService.getUserByEmail("mail"), user);
    }

    @Test
    void getUsersByName() {
        User user = userService.createUser(new UserDAO(1, "name", "mail"));
        List<User> users = new ArrayList<>();
        users.add(user);
        Assertions.assertEquals(userService.getUsersByName("name",1,1), users);
    }

    @Test
    void createUser() {
        User user = userService.createUser(new UserDAO(1, "name", "mail"));
        Assertions.assertEquals(userService.getUserById(1), user);
    }

    @Test
    void updateUser() {
        User user = userService.createUser(new UserDAO(1, "name", "mail"));
        User userNew = userService.updateUser(new UserDAO(1, "name1", "mail"));
        Assertions.assertEquals(userService.getUserById(1).getName(), "name1");
    }

    @Test
    void deleteUser() {
        User user = userService.createUser(new UserDAO(1, "name", "mail"));
        userService.deleteUser(1);
        Assertions.assertEquals(userService.getUserById(1), null);
    }

    @Test
    void bookTicket() {
    }

    @Test
    void getBookedTickets() {

    }

    @Test
    void cancelTicket() {
    }
}