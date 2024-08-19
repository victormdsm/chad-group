package com.eventflow.project.controllers;


import com.eventflow.project.dto.usersdto.ReturnUserDataDTO;
import com.eventflow.project.dto.usersdto.UserRegistrationDTO;
import com.eventflow.project.dto.usersdto.UserUpdateDTO;
import com.eventflow.project.services.UsersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/create")
    public ResponseEntity<ReturnUserDataDTO> save(@Valid @RequestBody UserRegistrationDTO userRegistrationDTO){
        try {
            ReturnUserDataDTO usuarioCriado = this.usersService.save(userRegistrationDTO);
            return new ResponseEntity<>(usuarioCriado, HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ReturnUserDataDTO> update(@PathVariable Long id, @Valid @RequestBody UserUpdateDTO userUpdateDTO){
        try {
            userUpdateDTO = new UserUpdateDTO(id, userUpdateDTO.username(), userUpdateDTO.email(), userUpdateDTO.phone());
            ReturnUserDataDTO usuarioAtualizado = this.usersService.update(userUpdateDTO);
            return new ResponseEntity<>(usuarioAtualizado, HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable long id){
        try{
            String msg = this.usersService.delete(id);
            return new ResponseEntity<>(msg,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findOne/{id}")
    public ResponseEntity<ReturnUserDataDTO> getUserById(@PathVariable Long id) {
       try {
           var user = usersService.findById(id);
           ReturnUserDataDTO user2 = new ReturnUserDataDTO(user);
           return new ResponseEntity<>(user2, HttpStatus.OK);
       }catch (Exception e) {
           e.printStackTrace();
           return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
       }
    }
    @GetMapping("/findAll")
    public ResponseEntity<List<ReturnUserDataDTO>> getAllUsers() {
        try{
            List<ReturnUserDataDTO> users = usersService.findAll();
            return new ResponseEntity<>(users, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }

    }
}
