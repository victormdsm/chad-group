package com.eventflow.project.services;

import com.eventflow.project.entities.UsersEventsEntity;
import com.eventflow.project.entities.enums.Status;
import com.eventflow.project.repositories.UsersEventsRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantEventsService {

    @Autowired
    private UsersEventsRepository participantEventsRepository;

    public UsersEventsEntity save(@Valid UsersEventsEntity participantsEventsEntity){
        return this.participantEventsRepository.save(participantsEventsEntity);
    }

    public UsersEventsEntity update(@Valid UsersEventsEntity participantsEventsEntity){
        return participantEventsRepository.save(participantsEventsEntity);
    }

    public String delete(@Valid Long id){
        if (participantEventsRepository.existsById(id)){
            participantEventsRepository.deleteById(id);
            return "Excluido com sucesso";
        }
        return null;
    }

    public UsersEventsEntity findById(@Valid Long id){
        UsersEventsEntity participantsEventsEntity = this.participantEventsRepository.findById(id).get();
        return participantsEventsEntity;

    }

    public List<UsersEventsEntity> findAll(){
        List<UsersEventsEntity> lista = this.participantEventsRepository.findAll();
        return lista;
    }

//    public long countParticipantsByEventIdAndStatus(Long eventId, Status status) {
//        return participantEventsRepository.countByEventIdAndStatus(eventId, status);
//    }
}
