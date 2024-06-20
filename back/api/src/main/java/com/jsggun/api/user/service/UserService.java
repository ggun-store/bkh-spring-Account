package com.jsggun.api.user.service;

import com.jsggun.api.common.component.Messenger;
import com.jsggun.api.common.service.CommandService;
import com.jsggun.api.common.service.QueryService;
import com.jsggun.api.user.model.User;
import com.jsggun.api.user.model.UserDto;

import java.util.List;
import java.util.Optional;


public interface UserService extends CommandService<UserDto>, QueryService<UserDto> {
    //command

    //query
    List<UserDto> findByName(String name);
    List<UserDto> findUsersByJob(String job);
    List<UserDto> findUsersByName(String name);
    Optional<UserDto> findUserByUsername(String username);


    default User dtoToEntity(UserDto userDto){
        return User.builder()
                .id(userDto.getId())
                .username(userDto.getUsername())
                .password(userDto.getPassword())
                .name(userDto.getName())
                .phone(userDto.getPhone())
                .job(userDto.getJob())
                .build();
    }

    default UserDto entityToDto(User user){
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .name(user.getName())
                .phone(user.getPhone())
                .job(user.getJob())
//                .regDate(String.valueOf(user.getRegDate()))
//                .modDate(String.valueOf(user.getRegDate()))
                .build();
    }

    Messenger login(UserDto param);

    Boolean existsByUsername(String param);

    Boolean logout(String accessToken);
}
