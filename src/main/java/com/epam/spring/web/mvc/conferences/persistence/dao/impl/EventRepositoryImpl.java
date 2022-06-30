package com.epam.spring.web.mvc.conferences.persistence.dao.impl;

import com.epam.spring.web.mvc.conferences.persistence.dao.EventRepository;
import com.epam.spring.web.mvc.conferences.persistence.model.Events;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class EventRepositoryImpl implements EventRepository {
    private final List<Events> list = new ArrayList<>();

    @Override
    public Events getEvent(int id) {
        log.info("Got Event by id: " + id);
        return list.stream().filter(events -> events.getEvent_id()==id)
                .findFirst().orElseThrow(RuntimeException::new);
    }

    @Override
    public Events createEvent(Events events) {
        list.add(events);
        log.info("Created Event " + events);
        return events;
    }

    @Override
    public Events updateEvent(int id, Events events) {
        boolean isUpdated = list.removeIf(e -> e.getEvent_id()==id);
        if (isUpdated) {
            list.add(events);
        } else {
            throw new RuntimeException("Event does not exists");
        }
        log.info("Event with id " + id + " was updated");
        return events;
    }

    @Override
    public void deleteEvent(int id) {
        list.removeIf(events -> events.getEvent_id()==id);
        log.info("Event with id {} was deleted", id);
    }
}
