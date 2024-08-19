package com.eventflow.project.services;

import com.eventflow.project.dto.usersdto.ReturnUserDataDTO;
import com.eventflow.project.dto.usersdto.UserRegistrationDTO;
import com.eventflow.project.dto.usersdto.UserUpdateDTO;
import com.eventflow.project.dto.usersdto.UsersDTO;
import com.eventflow.project.entities.UsersEntity;
import com.eventflow.project.repositories.UsersRepository;
import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public UsersEntity save(@Valid UsersEntity usersEntity){
        return this.usersRepository.save(usersEntity);
    }

    public UsersEntity update(@Valid UsersEntity usersEntity){
        this.usersRepository.save(usersEntity);
        return usersEntity;
    }


    public String delete(@Valid Long id){
        if (usersRepository.existsById(id)) {
            usersRepository.deleteById(id);
            return "Usuario Excluido";
        }
       return "Usuario Não existe";
    }
    public UsersEntity findById(@Valid Long id) {
        UsersEntity usersEntity = usersRepository.findById(id).get();
        return usersEntity;
    }

    public List<UsersEntity> findAll() {
        List<UsersEntity> lista = usersRepository.findAll();
        return lista;
    }
}
