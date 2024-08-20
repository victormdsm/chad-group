package com.eventflow.project.dto.invitationsdto;

import com.eventflow.project.dto.eventsdto.EventDTO;

public record InvitationCreateDTO(String email, EventDTO event) {
}
