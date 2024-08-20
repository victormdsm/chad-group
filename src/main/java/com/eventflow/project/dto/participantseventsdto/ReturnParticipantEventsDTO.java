package com.eventflow.project.dto.participantseventsdto;

import com.eventflow.project.entities.ParticipantsEventsEntity;

import java.time.LocalDateTime;

public record ReturnParticipantEventsDTO(String event, LocalDateTime dateAndTime, String participantName, LocalDateTime registrationDateTime) {
    public ReturnParticipantEventsDTO(ParticipantsEventsEntity pe){
        this(pe.getEvent().getTitle(), pe.getEvent().getStartDateTime(), pe.getParticipant().getName(), pe.getRegistrationDateTime());
    }
}
