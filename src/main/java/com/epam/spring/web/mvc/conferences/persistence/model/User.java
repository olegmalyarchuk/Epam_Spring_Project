package com.epam.spring.web.mvc.rentcarservice.persistence.model;

import com.epam.spring.web.mvc.rentcarservice.dto.CarDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private int id;
    private int role_id;
    private String user_name;
    private String user_surname;
    private String user_password;
    private String user_phone;
    private String user_email;
    private String user_photo_url;
    private String user_address;
    private User_roles user_roles;
}
