package com.eventflow.project.dto.participantseventsdto;

import com.eventflow.project.entities.Status;
import com.eventflow.project.entities.UserType;
import jakarta.validation.constraints.NotNull;

public record ParticipantsEventsUpdateDTO(
        @NotNull Long id,
        @NotNull Status status) {
}
