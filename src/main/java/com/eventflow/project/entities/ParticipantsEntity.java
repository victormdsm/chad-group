package com.eventflow.project.entities;

import com.eventflow.project.dto.participantsdto.ParticipantDTO;
import com.eventflow.project.dto.participantsdto.ParticipantRegistrationDTO;
import com.eventflow.project.dto.participantsdto.UpdateParticipantDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.User;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "participants_tb")
public class ParticipantsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "participant_name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone", nullable = false)
    private String phone;

    @OneToMany(mappedBy = "participant")
    private List<ParticipantsEventsEntity> participantsEvents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UsersEntity users;

    //TODO IMPLEMENTAR DEPOIS
//    @OneToMany(mappedBy = "participant")
//    private List<InvitationsEntity> invitations;

    public ParticipantsEntity(ParticipantRegistrationDTO dto, UsersEntity users) {
        this.name = dto.name();
        this.email = dto.email();
        this.phone = dto.phone();
        this.users = users;
    }

    public void updateFromDto(UpdateParticipantDTO dto){
        if(dto.nome() != null && !dto.nome().isEmpty()){
            this.name = dto.nome();
        }

        if (dto.email() != null && !dto.email().isEmpty()) {
            this.email = dto.email();
        }

        if(dto.phone() != null) {
            this.phone = dto.phone();
        }
    }



}
