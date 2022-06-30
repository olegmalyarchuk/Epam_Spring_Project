package com.epam.spring.web.mvc.conferences.service;

import com.epam.spring.web.mvc.conferences.dto.UserDto;

public interface UserService {
    UserDto getUser(String email);

    UserDto createUser(UserDto userDto);

    UserDto updateUser(String email, UserDto userDto);

    void deleteUser(String email);

}
