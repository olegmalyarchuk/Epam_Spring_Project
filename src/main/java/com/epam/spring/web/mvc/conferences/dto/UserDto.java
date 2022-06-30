package com.epam.spring.web.mvc.conferences.dto;

import com.epam.spring.web.mvc.conferences.persistence.model.User_roles;
import com.epam.spring.web.mvc.conferences.validation.AdvancedInfo;
import com.epam.spring.web.mvc.conferences.validation.BasicInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
    @NotNull
    private int id;
    @NotNull
    private int role_id;
    @Pattern(regexp = "^[A-ZА-Я][\\p{Alpha}А-Яа-я\\s-]{1,25}", groups = BasicInfo.class)
    @NotBlank(groups = AdvancedInfo.class)
    private String user_name;
    @Pattern(regexp = "^[A-ZА-Я][\\p{Alpha}А-Яа-я\\s-]{1,25}", groups = BasicInfo.class)
    @NotBlank(groups = AdvancedInfo.class)
    private String user_surname;
    @Pattern(regexp = "^([a-zA-Z0-9@*#]{4,16})$", groups = BasicInfo.class)
    @NotBlank(groups = AdvancedInfo.class)
    private String user_password;
    @Pattern(regexp = "^\\+\\d{9}$", groups = BasicInfo.class)
    @NotBlank(groups = AdvancedInfo.class)
    private String user_phone;
    @Email
    @NotBlank(groups = AdvancedInfo.class)
    private String user_email;
    @NotBlank(groups = AdvancedInfo.class)
    private String user_photo_url;
    @NotBlank(groups = AdvancedInfo.class)
    private String user_address;
    private User_roles user_roles;
}
