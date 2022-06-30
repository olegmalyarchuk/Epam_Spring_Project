package com.epam.spring.web.mvc.conferences.service;

import com.epam.spring.web.mvc.conferences.dto.EventsDTO;

public interface EventService {
    EventsDTO getEvent(int id);

    EventsDTO createEvent(EventsDTO eventsDTO);

    EventsDTO updateEvent(int id, EventsDTO eventsDTO);

    void deleteEvent(int id);
}
