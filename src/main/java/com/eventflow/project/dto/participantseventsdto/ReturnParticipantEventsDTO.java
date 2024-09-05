package com.eventflow.project.dto.participantseventsdto;

import com.eventflow.project.entities.UsersEventsEntity;

import java.time.LocalDateTime;

public record ReturnParticipantEventsDTO(String event, LocalDateTime dateAndTime, String participantName, LocalDateTime registrationDateTime) {
//    public ReturnParticipantEventsDTO(UsersEventsEntity pe){
//        this(pe.getEvent().getTitle(), pe.getEvent().getStartDateTime(), pe.getParticipant().getName(), pe.getRegistrationDateTime());
//    }
}
