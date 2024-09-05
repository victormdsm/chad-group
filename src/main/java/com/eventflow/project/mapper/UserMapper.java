package com.eventflow.project.mapper;


import com.eventflow.project.dto.usersdto.ReturnUserDataDTO;
import com.eventflow.project.dto.usersdto.UserDto;
import com.eventflow.project.dto.usersdto.UserRegistrationDTO;
import com.eventflow.project.dto.usersdto.UsersDTO;
import com.eventflow.project.entities.UsersEntity;
import org.apache.catalina.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.awt.*;

@Mapper(componentModel = "spring")
public interface UserMapper {


    UsersEntity dtoResgisteryToEntity(UserRegistrationDTO dto);
    ReturnUserDataDTO usersToUsersDTO(UsersEntity user);
    UsersEntity usersDtoToUser(UserDto dto);
}
