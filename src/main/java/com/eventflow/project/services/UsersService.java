package com.eventflow.project.services;

import com.eventflow.project.dto.usersdto.ReturnUserDataDTO;
import com.eventflow.project.dto.usersdto.UserRegistrationDTO;
import com.eventflow.project.dto.usersdto.UserUpdateDTO;
import com.eventflow.project.dto.usersdto.UsersDTO;
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

    public ReturnUserDataDTO save(@Valid UserRegistrationDTO userRegistrationDTO){
       UsersEntity usersEntity = new UsersEntity(userRegistrationDTO);
       UsersEntity entidadeSalva = this.usersRepository.save(usersEntity);
       return new ReturnUserDataDTO(entidadeSalva);
    }

    public ReturnUserDataDTO update(@Valid UserUpdateDTO userUpdateDTO){
        UsersEntity usersEntity = usersRepository.findById(userUpdateDTO.id())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
        usersEntity.setUsername(userUpdateDTO.username());
        usersEntity.setEmail(userUpdateDTO.email());
        usersEntity.setPhone(userUpdateDTO.phone());
        UsersEntity entidadeAtualizada = usersRepository.save(usersEntity);
        return new ReturnUserDataDTO(entidadeAtualizada);
    }


    public String delete(@Valid Long id){
        if (usersRepository.existsById(id)) {
            usersRepository.deleteById(id);
            return "Usuario Excluido";
        }
       return "Usuario Não existe";
    }
    public ReturnUserDataDTO findById(Long id) {
        UsersEntity usersEntity = usersRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
        return new ReturnUserDataDTO(usersEntity);
    }

    public List<ReturnUserDataDTO> findAll() {
        List<UsersEntity> lista = usersRepository.findAll();
        return lista.stream()
                .map(ReturnUserDataDTO::new)
                .toList();
    }
}
