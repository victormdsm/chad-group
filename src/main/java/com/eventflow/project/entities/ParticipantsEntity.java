package com.eventflow.project.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "participants")
public class ParticipantsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Email
    private String email;
    private String phone;

    @OneToMany(mappedBy = "participant")
    private List<RegistrationEntity> registrations;

    @OneToMany(mappedBy = "participant")
    private List<InvitationsEntity> invitations;

    @OneToMany(mappedBy = "participant")
    private List<AttendancesEntity> attendances;

}
