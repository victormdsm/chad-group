package com.eventflow.project.mapper;

import com.eventflow.project.dto.eventsdto.EventDTO;
import com.eventflow.project.dto.participantsdto.ParticipantDTO;
import com.eventflow.project.dto.participantseventsdto.ParticipantEventRegistrationDTO;
import com.eventflow.project.entities.EventsEntitiy;
import com.eventflow.project.entities.ParticipantsEntity;
import com.eventflow.project.entities.ParticipantsEventsEntity;
import com.eventflow.project.entities.Status;

import java.time.LocalDateTime;

public class ParticipantsEventsMapper {

    public static ParticipantsEventsEntity participantsEventsDTOtoParticipantsEventsEntity(ParticipantEventRegistrationDTO dto) {
        return new ParticipantsEventsEntity(null, LocalDateTime.now(), Status.PENDING, ParticipantDTOtoParticipantsEntity(dto.participant()), EventDTOtoEventesEntity(dto.event()));
    }

    public static EventsEntitiy EventDTOtoEventesEntity(EventDTO dto){
        return new EventsEntitiy(dto.getId());
    }

    public static ParticipantsEntity ParticipantDTOtoParticipantsEntity(ParticipantDTO dto){
        return new ParticipantsEntity(dto.id());
    }
}
