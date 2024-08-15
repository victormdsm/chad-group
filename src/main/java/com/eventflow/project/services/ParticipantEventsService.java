package com.eventflow.project.services;

import com.eventflow.project.entities.ParticipantsEventsEntity;
import com.eventflow.project.repositories.ParticipantEventsRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantEventsService {

    @Autowired
    private ParticipantEventsRepository participantEventsRepository;

    public ParticipantsEventsEntity save(@Valid ParticipantsEventsEntity participantsEventsEntity){
        return this.participantEventsRepository.save(participantsEventsEntity);
    }

    public ParticipantsEventsEntity update(@Valid ParticipantsEventsEntity participantsEventsEntity, Long id){
        if (participantEventsRepository.existsById(id)){
            participantsEventsEntity.setId(id);
            participantEventsRepository.save(participantsEventsEntity);
            return participantsEventsEntity;
        }
        return null;
    }

    public String delete(@Valid Long id){
        if (participantEventsRepository.existsById(id)){
            participantEventsRepository.deleteById(id);
            return "Excluido com sucesso";
        }
        return null;
    }

    public ParticipantsEventsEntity findById(@Valid Long id){
        ParticipantsEventsEntity participantsEventsEntity = this.participantEventsRepository.findById(id).get();
        return participantsEventsEntity;

    }

    public List<ParticipantsEventsEntity> findAll(){
        List<ParticipantsEventsEntity> lista = this.participantEventsRepository.findAll();
        return lista;
    }
}
