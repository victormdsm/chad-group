package com.eventflow.project.dto.participantsdto;


import com.eventflow.project.entities.ParticipantsEntity;

public record ReturnParticipantDataDTO(String name, String email, String phone) {
    public ReturnParticipantDataDTO(ParticipantsEntity participant) {
        this(participant.getName(), participant.getEmail(), participant.getPhone());
    }
}
