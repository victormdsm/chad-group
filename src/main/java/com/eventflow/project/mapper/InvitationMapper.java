package com.eventflow.project.mapper;

import com.eventflow.project.dto.eventsdto.EventDTO;
import com.eventflow.project.dto.invitationsdto.InvitationCreateDTO;
import com.eventflow.project.entities.EventsEntitiy;
import com.eventflow.project.entities.InvitationsEntity;

public class InvitationMapper {

    public static InvitationsEntity InvitationCreatDTOtoInvitationEntity(InvitationCreateDTO dto) {
        return new InvitationsEntity(dto, EventDTOtoEventesEntity(dto.event()));
    }

    public static EventsEntitiy EventDTOtoEventesEntity(EventDTO dto){
        return new EventsEntitiy(dto.getId());
    }
}
