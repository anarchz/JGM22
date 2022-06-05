package com.controller;

import com.dao.EventDAO;
import com.facade.BookingFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
public class EventController {
    @Autowired
    private BookingFacade booking;

    @GetMapping("/eventsByTitle")
    public ModelAndView getEventsBy(@RequestParam String title) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("eventsByTitle");
        mv.getModel().put("eventsByTitle", booking.getEventsByTitle(title,5, 1));
        return mv;
    }

    @PostMapping
    public ModelAndView create(){
        return null;
    }
}
