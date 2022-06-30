package com.epam.spring.web.mvc.conferences.persistence.dao;

import com.epam.spring.web.mvc.conferences.persistence.model.Events;

public interface EventRepository {
    Events getEvent(int id);

    Events createEvent(Events events);

    Events updateEvent(int id, Events events);

    void deleteEvent(int id);
}
