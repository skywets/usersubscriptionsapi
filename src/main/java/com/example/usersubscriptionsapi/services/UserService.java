package com.example.usersubscriptionsapi.services;

import com.example.usersubscriptionsapi.models.dtos.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    void create(UserDto userDto);


    void updateUser(Long id, UserDto userDto);

    void delete(Long id);

    UserDto findByid(Long id);

    List<UserDto> findAll();
}
