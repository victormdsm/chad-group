package com.eventflow.project.entities;

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

    @NotNull @Email @Column(name = "email", nullable = false)
    private String email;

    @NotNull @Column(name = "invite_date_time", nullable = false)
    private LocalDateTime invitationDateTime;

    @ManyToOne
    @JoinColumn(name = "event_id",nullable = false)
    private EventsEntitiy event;

    @ManyToOne
    @JoinColumn(name = "participant_id", nullable = false)
    private ParticipantsEntity participant;

}
