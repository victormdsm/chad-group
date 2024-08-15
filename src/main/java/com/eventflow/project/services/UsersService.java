package com.eventflow.project.services;

import com.eventflow.project.entities.UsersEntity;
import com.eventflow.project.repositories.UsersRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public UsersEntity save( @Valid UsersEntity usersEntity){
        return this.usersRepository.save(usersEntity);

    }

    public UsersEntity update(@Valid UsersEntity usersEntity , Long id){
        if (usersRepository.existsById(id)) {
            usersEntity.setId(id);
            return usersRepository.save(usersEntity);
        }
        return null;
    }
    public String delete(@Valid Long id){
        if (usersRepository.existsById(id)) {
            usersRepository.deleteById(id);
            return "Usuario Excluido";
        }
       return "Usuario Não existe";
    }
    public UsersEntity findById(Long id){
        UsersEntity usersEntity = this.usersRepository.findById(id).get();
        return usersEntity;
    }

    public List<UsersEntity> findAll(){
        List<UsersEntity> lista = this.usersRepository.findAll();
        return lista;
    }
}
