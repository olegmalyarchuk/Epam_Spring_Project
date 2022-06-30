package com.epam.spring.web.mvc.conferences.controller;

import com.epam.spring.web.mvc.conferences.dto.EventsDTO;
import com.epam.spring.web.mvc.conferences.service.EventService;
import com.epam.spring.web.mvc.conferences.validation.BasicInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}")
    public EventsDTO getEvent(@PathVariable int id) {
        log.info("Getting Event with id{}", id);
        return eventService.getEvent(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public EventsDTO createEvent(@Validated(BasicInfo.class) @RequestBody EventsDTO eventsDTO) {
        log.info("creating event{}", eventsDTO);
        return eventService.createEvent(eventsDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{id}")
    public EventsDTO updateEvent(@PathVariable int id, @RequestBody EventsDTO eventsDTO) {
        log.info("Updating event with id{}", id);
        return eventService.updateEvent(id, eventsDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable int id) {
        log.info("Deleting event with id{}", id);
        eventService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }
}
