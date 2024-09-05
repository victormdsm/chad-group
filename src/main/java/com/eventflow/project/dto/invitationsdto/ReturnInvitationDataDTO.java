package com.eventflow.project.dto.invitationsdto;

import com.eventflow.project.entities.InvitationsEntity;

public record ReturnInvitationDataDTO (String email, String eventName){
//    public ReturnInvitationDataDTO(InvitationsEntity invitation){
//        this(invitation.getEmail(), invitation.getEvent().getTitle());
//    }
}
