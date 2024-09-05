package com.eventflow.project.dto.usersdto;

import com.eventflow.project.entities.UsersEntity;

public record ReturnUserDataDTO(Long id, String username, String email, String phone) {
//    TODO refactor return dto
//    public ReturnUserDataDTO(UsersEntity user){
//        this(user.getId(), user.getUsername(), user.getEmail(), user.getPhone());
//    }
}
