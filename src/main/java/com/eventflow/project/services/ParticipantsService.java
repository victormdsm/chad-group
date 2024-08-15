package com.eventflow.project.services;

import com.eventflow.project.entities.ParticipantsEntity;
import com.eventflow.project.repositories.ParticipantsRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantsService {

    @Autowired
    private ParticipantsRepository participantsRepository;

   public ParticipantsEntity save(@Valid ParticipantsEntity participantsEntity){
       return this.participantsRepository.save(participantsEntity);
   }

   public ParticipantsEntity update(@Valid ParticipantsEntity participantsEntity, Long id){
       if (participantsRepository.existsById(id)){
           participantsEntity.setId(id);
           return participantsRepository.save(participantsEntity);
       }
       return null;
   }

   public String delete(@Valid Long id){
       if (participantsRepository.existsById(id)){
           participantsRepository.deleteById(id);
           return "Participante Excluido";
       }
       return null;
   }

   public ParticipantsEntity findById(@Valid Long id){
       ParticipantsEntity participantsEntity = this.participantsRepository.findById(id).get();
       return participantsEntity;
   }

   public List<ParticipantsEntity> findAll(){
       List<ParticipantsEntity> lista = this.participantsRepository.findAll();
       return lista;
   }
}
