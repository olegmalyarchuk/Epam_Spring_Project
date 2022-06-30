package com.epam.spring.web.mvc.rentcarservice.persistence.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Event_users {
    private int id;
    private int user_id;
    private int event_id;
    private boolean present;
    private User user;
}
