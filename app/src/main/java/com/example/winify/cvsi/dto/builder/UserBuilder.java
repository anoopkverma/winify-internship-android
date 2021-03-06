package com.example.winify.cvsi.dto.builder;


import com.example.winify.cvsi.dto.UserDto;
import com.example.winify.cvsi.model.User;

/**
 * Created by Artemie on 28.06.2016.
 */
public class UserBuilder {

    public User getUser(UserDto userDto){
        User user = new User();
        user.setUsername(userDto.getUserName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setPhone(userDto.getPhone());
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        return user;
    }
    public UserDto getUser(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUserName(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setPhone(user.getPhone());
        userDto.setName(user.getName());
        userDto.setSurname(user.getSurname());
        return userDto;
    }
}
