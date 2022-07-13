package com.controller;

import com.dto.Event;
import com.service.EventServiceImpl;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import com.service.EventService;

import java.util.List;


@RestController
@Api(value = "eventService")
public class EventServiceController {
    EventService service = new EventServiceImpl();

    @ApiOperation(value = "get event by id", response = Event.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved event"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping(value = "/events/{id}", produces = "application/json")
    public Event get(@ApiParam(value = "eventId",required = true) @PathVariable Integer id ) {
        return service.getEvent(id);
    }

    @ApiOperation(value = "get all events by title")
    @ApiImplicitParams({@ApiImplicitParam(value = "title1", name = "title")})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved events"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping(value = "/events", params = "title", produces = "application/json")
    public List<Event> getAllByTitle(@RequestParam String title) {
        return service.getAllEventsByTitle(title);
    }


    @ApiOperation(value = "get all events")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved events"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping(value = "/events/list", produces = "application/json")
    public List<Event> getAll() {
        return service.getAllEvents();
    }

    @ApiOperation(value = "delete event")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully delete event"),
            @ApiResponse(code = 401, message = "You are not authorized to delete the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @DeleteMapping(value = "/events/{id}", produces = "application/json")
    public Event delete(@ApiParam(value = "eventId",required = true)@PathVariable Integer id ) {
        return service.deleteEvent(id);
    }

    @ApiOperation(value = "create event")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created event"),
            @ApiResponse(code = 401, message = "You are not authorized to create the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @PostMapping(value = "/events", produces = "application/json")
    public Event create(@RequestBody Event event) {
        return service.updateEvent(event);
    }

}
