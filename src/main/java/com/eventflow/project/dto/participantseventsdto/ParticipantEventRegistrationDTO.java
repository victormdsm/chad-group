package com.eventflow.project.dto.participantseventsdto;

import com.eventflow.project.dto.eventsdto.EventDTO;
import jakarta.validation.constraints.NotNull;

public record ParticipantEventRegistrationDTO(
        @NotNull EventDTO event
        ) {
}
