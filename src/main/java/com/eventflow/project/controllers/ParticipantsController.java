package com.eventflow.project.controllers;

import com.eventflow.project.dto.participantsdto.ParticipantRegistrationDTO;
import com.eventflow.project.dto.participantsdto.ReturnParticipantDataDTO;
import com.eventflow.project.dto.participantsdto.UpdateParticipantDTO;
import com.eventflow.project.entities.ParticipantsEntity;
import com.eventflow.project.services.ParticipantsService;
import com.eventflow.project.services.UsersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.eventflow.project.mapper.ParticipantMapper.ParticipantDtoParticipantEntity;

@RestController
@RequestMapping("/api/participants")
public class ParticipantsController {

    @Autowired
    ParticipantsService participantService;
    @Autowired
    UsersService usersService;

    @PostMapping("/create")
    public ResponseEntity<ReturnParticipantDataDTO> save(@RequestBody @Valid ParticipantRegistrationDTO dto){
        try {
            var participant = ParticipantDtoParticipantEntity(dto);
            participantService.save(participant);
            return new ResponseEntity<>(new ReturnParticipantDataDTO(participant), HttpStatus.CREATED);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("update/{id}")
    public ResponseEntity<ReturnParticipantDataDTO> update (@PathVariable Long id, @RequestBody @Valid UpdateParticipantDTO dto) {
        try {
            var atualizar = participantService.findById(id);
            atualizar.updateFromDto(dto);
            ReturnParticipantDataDTO retorno = new ReturnParticipantDataDTO(participantService.update(atualizar));
            return new ResponseEntity<>(retorno, HttpStatus.CREATED);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("findbyid/{id}")
    public ResponseEntity<ReturnParticipantDataDTO> findbyid(@PathVariable Long id) {
        try {
            var participant = participantService.findById(id);
            ReturnParticipantDataDTO retorno = new ReturnParticipantDataDTO(participant);
            return new ResponseEntity<>(retorno, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findall")
    public ResponseEntity<List<ReturnParticipantDataDTO>> findAll(){
        try {
            List<ParticipantsEntity> participants = participantService.findAll();
            return new ResponseEntity<>(participants.stream()
                    .map(ReturnParticipantDataDTO::new)
                    .collect(Collectors.toList()), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }
}
