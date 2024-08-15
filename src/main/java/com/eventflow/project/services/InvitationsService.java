package com.eventflow.project.services;

import com.eventflow.project.entities.InvitationsEntity;
import com.eventflow.project.repositories.InvitationsRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvitationsService {

    @Autowired
    private InvitationsRepository invitationsRepository;

    public InvitationsEntity save(@Valid InvitationsEntity invitationsEntity){
        return this.invitationsRepository.save(invitationsEntity);
    }

    public InvitationsEntity update(@Valid InvitationsEntity invitationsEntity, Long id){
        if (invitationsRepository.existsById(id)){
            invitationsEntity.setId(id);
            invitationsRepository.save(invitationsEntity);
            return invitationsEntity;
        }
        return null;
    }

    public String delete(@Valid Long id){
        if (invitationsRepository.existsById(id)){
            invitationsRepository.deleteById(id);
            return "Excluido com sucesso";
        }
        return null;
    }

    public InvitationsEntity findById(@Valid Long id){
        InvitationsEntity invitationsEntity = this.invitationsRepository.findById(id).get();
        return invitationsEntity;
    }

    public List<InvitationsEntity> findAll(){
        List<InvitationsEntity> lista = this.invitationsRepository.findAll();
        return lista;
    }
}
