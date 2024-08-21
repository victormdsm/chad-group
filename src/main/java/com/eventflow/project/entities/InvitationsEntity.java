package com.eventflow.project.entities;

import com.eventflow.project.dto.invitationsdto.InvitationCreateDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "invitations_tb")
public class InvitationsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "invite_date_time", nullable = false)
    private LocalDateTime invitationDateTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "event_id",nullable = false)
    private EventsEntitiy event;

    public InvitationsEntity(InvitationCreateDTO dto, EventsEntitiy event){
        this.email = dto.email();
        this.invitationDateTime = LocalDateTime.now();
        this.event = event;
    }
}
