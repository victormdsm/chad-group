package com.eventflow.project.controllers;

import com.eventflow.project.dto.participantsdto.ReturnParticipantDataDTO;
import com.eventflow.project.dto.participantseventsdto.ParticipantEventRegistrationDTO;
import com.eventflow.project.dto.participantseventsdto.ReturnParticipantEventsDTO;
import com.eventflow.project.services.ParticipantEventsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.eventflow.project.mapper.ParticipantMapper.ParticipantDtoParticipantEntity;
import static com.eventflow.project.mapper.ParticipantsEventsMapper.participantsEventsDTOtoParticipantsEventsEntity;

@RestController
@RequestMapping("/api/participantevents")
public class ParticipantEventsController {


    @Autowired
    ParticipantEventsService partEvenService;

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody @Valid ParticipantEventRegistrationDTO dto) {
        try {
            var participant = participantsEventsDTOtoParticipantsEventsEntity(dto);
            partEvenService.save(participant);
            return new ResponseEntity<>(new ReturnParticipantEventsDTO(participant), HttpStatus.CREATED);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }
}
