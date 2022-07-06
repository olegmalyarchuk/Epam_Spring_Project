package com.epam.spring.web.mvc.conferences.service.impl;

import com.epam.spring.web.mvc.conferences.dto.EventsDTO;
import com.epam.spring.web.mvc.conferences.dto.UserDto;
import com.epam.spring.web.mvc.conferences.persistence.dao.EventRepository;
import com.epam.spring.web.mvc.conferences.persistence.model.Events;
import com.epam.spring.web.mvc.conferences.persistence.model.User;
import com.epam.spring.web.mvc.conferences.service.EventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;


    @Override
    public EventsDTO getEvent(int id) {
        log.info("EventService: get event by id {}", id);
        return mapEventToEventDto(eventRepository.getEvent(id));
    }

    @Override
    public EventsDTO createEvent(EventsDTO eventsDTO) {
        Events events = mapEventDtoToEvent(eventsDTO);
        events = eventRepository.createEvent(events);
        log.info("EventService: create event {}", eventsDTO);
        return mapEventToEventDto(events);
    }

    @Override
    public EventsDTO updateEvent(int id, EventsDTO eventsDTO) {
        Events events = mapEventDtoToEvent(eventsDTO);
        events = eventRepository.updateEvent(id, events);
        log.info("EventService: update event with id {}", id);
        return mapEventToEventDto(events);
    }

    @Override
    public void deleteEvent(int id) {
        eventRepository.deleteEvent(id);
        log.info("EventService: delete event with id {}", id);
    }

    @Override
    public int calculateEventsNumber() {
        log.info("EventService: events count{}", eventRepository.calculateEventsNumber());
        return eventRepository.calculateEventsNumber();
    }

    @Override
    public List<EventsDTO> getEventByPlaceUA(String event_place_ua) {
        log.info("Got Events by place_ua: " + event_place_ua);
        List<Events> eventsList = eventRepository.getEventByPlaceUA(event_place_ua);
        List<EventsDTO> eventsDTOList = eventsList.stream().map(e -> mapEventToEventDto(e)).collect(Collectors.toList());
        return eventsDTOList;
    }

    @Override
    public List<EventsDTO> getEventByPlaceEN(String event_place_en) {
        log.info("Got Events by place_en: " + event_place_en);
        List<Events> eventsList = eventRepository.getEventByPlaceUA(event_place_en);
        List<EventsDTO> eventsDTOList = eventsList.stream().map(e -> mapEventToEventDto(e)).collect(Collectors.toList());
        return eventsDTOList;
    }

    private Events mapEventDtoToEvent(EventsDTO eventsDTO) {
        return Events.builder().event_id(eventsDTO.getEvent_id())
                .event_name_ua(eventsDTO.getEvent_name_ua())
                .event_name_en(eventsDTO.getEvent_name_en())
                .event_place_ua(eventsDTO.getEvent_place_ua())
                .event_place_en(eventsDTO.getEvent_place_en())
                .event_description_ua(eventsDTO.getEvent_description_ua())
                .event_description_en(eventsDTO.getEvent_description_en())
                .event_date(eventsDTO.getEvent_date())
                .event_photo_url(eventsDTO.getEvent_photo_url())
                .build();
    }

    private EventsDTO mapEventToEventDto(Events events) {
        return EventsDTO.builder().event_id(events.getEvent_id())
                .event_name_ua(events.getEvent_name_ua())
                .event_name_en(events.getEvent_name_en())
                .event_place_ua(events.getEvent_place_ua())
                .event_place_en(events.getEvent_place_en())
                .event_description_ua(events.getEvent_description_ua())
                .event_description_en(events.getEvent_description_en())
                .event_date(events.getEvent_date())
                .event_photo_url(events.getEvent_photo_url())
                .build();
    }

}
