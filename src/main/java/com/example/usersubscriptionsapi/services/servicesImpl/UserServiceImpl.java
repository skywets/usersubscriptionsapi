package com.example.usersubscriptionsapi.services.servicesImpl;

import com.example.usersubscriptionsapi.exceptions.NotFoundException;
import com.example.usersubscriptionsapi.models.dtos.UserDto;
import com.example.usersubscriptionsapi.models.entites.User;
import com.example.usersubscriptionsapi.models.mapper.MapperDto;
import com.example.usersubscriptionsapi.repositories.UserRepository;
import com.example.usersubscriptionsapi.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("userService")
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private MapperDto<UserDto, User, UserDto> mapperDto;
    @Override
    public void create(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        userRepository.save(user);
    }

    @Override
    public void updateUser(Long id, UserDto userDto) {
        User user = getByIdOrElseThrow(id);
        user.setName(userDto.getName());
        userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        User user = getByIdOrElseThrow(id);
        userRepository.delete(user);
    }

    @Override
    public UserDto findByid(Long id) {
        return mapperDto.mapToDto(getByIdOrElseThrow(id));
    }

    @Override
    public List<UserDto> findAll() {
        return mapperDto.maptoDto(userRepository.findAll());
    }

    private User getByIdOrElseThrow(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new NotFoundException("The User does not exist"));
    }
}
