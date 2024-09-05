package com.eventflow.project.controllers;

import com.eventflow.project.dto.usersdto.ReturnUserDataDTO;
import com.eventflow.project.dto.usersdto.UserRegistrationDTO;
import com.eventflow.project.dto.usersdto.UserUpdateDTO;
import com.eventflow.project.entities.UsersEntity;
import com.eventflow.project.mapper.UserMapper;
import com.eventflow.project.services.UsersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private UserMapper mapper;

    @PostMapping("/create")
    public ResponseEntity<UsersEntity> save(@RequestBody @Valid UserRegistrationDTO dto) {
        try {
            UsersEntity obj = mapper.dtoResgisteryToEntity(dto);

//            usersService.save(obj);
            return new ResponseEntity<>(obj, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
//
//    @PutMapping("/update/{id}")
//    public ResponseEntity<ReturnUserDataDTO> update(@PathVariable Long id, @RequestBody @Valid UserUpdateDTO dto) {
//        try {
//            var user = usersService.findById(id);
//            user.updateFromDto(dto);
//            ReturnUserDataDTO retorno = new ReturnUserDataDTO(usersService.update(user));
//            return new ResponseEntity<>(retorno, HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @GetMapping("/findbyid/{id}")
//    public ResponseEntity<ReturnUserDataDTO> findById(@PathVariable Long id) {
//        try {
//            var user = usersService.findById(id);
//            ReturnUserDataDTO retorno = new ReturnUserDataDTO(user);
//            return new ResponseEntity<>(retorno, HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @GetMapping("/findall")
//    public ResponseEntity<List<ReturnUserDataDTO>> findAll() {
//        try {
//            List<UsersEntity> users = usersService.findAll();
//            return new ResponseEntity<>(users.stream()
//                    .map(ReturnUserDataDTO::new)
//                    .collect(Collectors.toList()), HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<String> delete(@PathVariable Long id) {
//        try {
//            String message = usersService.delete(id);
//            return new ResponseEntity<>(message, HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//        }
//    }
}
