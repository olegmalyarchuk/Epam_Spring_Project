package com.epam.spring.web.mvc.conferences.service.impl;

import com.epam.spring.web.mvc.conferences.dto.UserDto;
import com.epam.spring.web.mvc.conferences.persistence.model.User;
import com.epam.spring.web.mvc.conferences.persistence.dao.UserRepository;
import com.epam.spring.web.mvc.conferences.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDto getUser(String email) {
        log.info("UserService: get user by email {}", email);
        return mapUserToUserDto(userRepository.getUser(email));
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = mapUserDtoToUser(userDto);
        user = userRepository.createUser(user);
        log.info("UserService: create user {}", userDto);
        return mapUserToUserDto(user);
    }

    @Override
    public UserDto updateUser(String email, UserDto userDto) {
        User user = mapUserDtoToUser(userDto);
        user = userRepository.updateUser(email, user);
        log.info("UserService: update user with email {}", email);
        return mapUserToUserDto(user);
    }

    @Override
    public void deleteUser(String email) {
        userRepository.deleteUser(email);
        log.info("UserService: delete user with email {}", email);
    }

    @Override
    public int calculateUsersNumber() {
        log.info("UserService: users count{}", userRepository.calculateUsersNumber());
        return userRepository.calculateUsersNumber();
    }

    @Override
    public List<UserDto> getUsersByRoleId(int role_id) {
        log.info("Got Users by role_id: " + role_id);
        List<User> userList = userRepository.getUsersByRoleId(role_id);
        List<UserDto> userDtoList = userList.stream().map(u -> mapUserToUserDto(u)).collect(Collectors.toList());
        return userDtoList;
    }


    private User mapUserDtoToUser(UserDto userDto) {
        return User.builder().id(userDto.getId())
                .role_id(userDto.getRole_id())
                .user_name(userDto.getUser_name())
                .user_surname(userDto.getUser_surname())
                .user_password(userDto.getUser_password())
                .user_phone(userDto.getUser_phone())
                .user_email(userDto.getUser_email())
                .user_photo_url(userDto.getUser_photo_url())
                .user_address(userDto.getUser_address())
                .build();
    }

    private UserDto mapUserToUserDto(User user) {
        return UserDto.builder().id(user.getId())
                .role_id(user.getRole_id())
                .user_name(user.getUser_name())
                .user_surname(user.getUser_surname())
                .user_password(user.getUser_password())
                .user_phone(user.getUser_phone())
                .user_email(user.getUser_email())
                .user_photo_url(user.getUser_photo_url())
                .user_address(user.getUser_address())
                .build();
    }
}
