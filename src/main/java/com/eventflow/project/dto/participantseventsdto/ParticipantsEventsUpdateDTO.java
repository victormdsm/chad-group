package com.eventflow.project.dto.participantseventsdto;

import com.eventflow.project.entities.enums.Status;
import jakarta.validation.constraints.NotNull;

public record ParticipantsEventsUpdateDTO(
        @NotNull Long id,
        @NotNull Status status) {
}
