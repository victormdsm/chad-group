package com.eventflow.project.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "events_tb")
public class EventsEntitiy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull @NotBlank @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "event_description")
    private String description;

    @NotNull @Column(name = "start_date_time", nullable = false)
    private LocalDateTime startDateTime;

    @NotNull @Column(name = "end_date_time", nullable = false)
    private LocalDateTime endDateTime;

    @NotNull @NotBlank @Column(name = "location", nullable = false)
    private String location;

    @NotNull @Column(name = "capacity",nullable = false)
    private int capacity;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UsersEntity user;

    @ManyToMany( mappedBy = "events")
    private List<ParticipantsEntity> participants = new ArrayList<>();

    @OneToMany(mappedBy = "event")
    private List<ParticipantsEventsEntity> participantsEvents;

    @OneToMany(mappedBy = "event")
    private List<InvitationsEntity> invitations;
}
