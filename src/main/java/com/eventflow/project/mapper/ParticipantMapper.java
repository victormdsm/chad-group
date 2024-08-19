package com.eventflow.project.mapper;

import com.eventflow.project.dto.participantsdto.ParticipantRegistrationDTO;
import com.eventflow.project.dto.usersdto.UserDto;
import com.eventflow.project.entities.ParticipantsEntity;
import com.eventflow.project.entities.UsersEntity;


public class ParticipantMapper {

    public static ParticipantsEntity ParticipantDtoParticipantEntity(ParticipantRegistrationDTO dto) {
        return new ParticipantsEntity(dto, UserDtoToUsersEntity(dto.dto()));
    }

    public static UsersEntity UserDtoToUsersEntity(UserDto dto) {
        return new UsersEntity(dto.id(), dto.username(), dto.email(),
        dto.password(), dto.phone(), null, dto.userType());
    }
}
