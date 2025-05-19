package com.example.usersubscriptionsapi.models.mapper;

import com.example.usersubscriptionsapi.models.dtos.UserDto;
import com.example.usersubscriptionsapi.models.entites.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class UserImplMapper implements MapperDto<UserDto, User, UserDto> {

    @Override
    public UserDto mapToDto(User entity) {
        UserDto userDto = new UserDto();
        userDto.setId(entity.getId());
        userDto.setName(entity.getName());
        return userDto;
    }

    @Override
    public User mapToEntity(UserDto dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        return user;
    }

    @Override
    public List<UserDto> maptoDto(Iterable<User> entities) {
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : entities) {
            userDtos.add(mapToDto(user));
        }
        return userDtos;
    }

    @Override
    public List<User> mapToEntity(Iterable<UserDto> dtos) {
        List<User> users = new ArrayList<>();
        for (UserDto userDto : dtos) {
            users.add(mapToEntity(userDto));
        }
        return users;
    }
}
