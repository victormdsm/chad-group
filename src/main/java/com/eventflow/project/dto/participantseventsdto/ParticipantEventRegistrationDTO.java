package com.eventflow.project.dto.participantseventsdto;

import com.eventflow.project.dto.eventsdto.EventDTO;
import com.eventflow.project.dto.participantsdto.ParticipantDTO;
import jakarta.validation.constraints.NotNull;

public record ParticipantEventRegistrationDTO(
        @NotNull ParticipantDTO participant,
        @NotNull EventDTO event
        ) {
}
