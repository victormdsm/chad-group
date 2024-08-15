package com.eventflow.project.entities;

import jakarta.persistence.*;
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
@Table(name = "Attendances")
public class AttendancesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_id",nullable = false)
    private EventsEntitiy event;

    @ManyToOne
    @JoinColumn(name = "participant_id",nullable = false)
    private ParticipantsEntity participant;

    private LocalDateTime arrivalDateTime;


    private Status status;
}
