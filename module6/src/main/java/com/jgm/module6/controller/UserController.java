package com.jgm.module6.controller;

import com.jgm.module6.entity.User;
import com.jgm.module6.facade.BookingFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private BookingFacade booking;

    @GetMapping("/user/byEmail")
    public User get(@RequestParam String email) {
        return booking.getUserByEmail(email);
    }

    @GetMapping("/user/byId")
    public User get(@RequestParam Long id) {
        return booking.getUserById(id);
    }

    @GetMapping("/user/byName")
    public List<User> getAllByName(@RequestParam String name) {
        return booking.getUsersByName(name, 5, 0);
    }

    @GetMapping("/user/delete/{id}")
    public Boolean delete(@PathVariable("id") Long id) {
        return booking.deleteUser(id);
    }

    @PostMapping("/user/create")
    public User create(@RequestBody User user){
        return booking.createUser(user);
    }
}
