package com.eventflow.project.entities;

import jakarta.persistence.*;
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
@Table(name = "participants_events_tb")
public class ParticipantsEventsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull @Column(name = "registration_date_time",nullable = false)
    private LocalDateTime registrationDateTime;

    @NotNull @Column(name = "participant_status") @Enumerated(EnumType.STRING)
    private Status participantStatus;

    @ManyToOne
    @JoinColumn(name = "participant_id",nullable = false)
    private ParticipantsEntity participant;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private EventsEntitiy event;
}
