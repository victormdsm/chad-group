package com.eventflow.project.controllers;

import com.eventflow.project.dto.participantsdto.ReturnParticipantDataDTO;
import com.eventflow.project.dto.participantseventsdto.ParticipantEventRegistrationDTO;
import com.eventflow.project.dto.participantseventsdto.ParticipantsEventsUpdateDTO;
import com.eventflow.project.dto.participantseventsdto.ReturnParticipantEventsDTO;
import com.eventflow.project.entities.ParticipantsEventsEntity;
import com.eventflow.project.services.ParticipantEventsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

    @PutMapping("/update/{id}")
    public ResponseEntity update(@RequestBody @Valid ParticipantsEventsUpdateDTO dto, @PathVariable Long id) {
        try {
            var participant = partEvenService.findById(id);
            participant.update(dto);
            partEvenService.update(participant);
            return new ResponseEntity<>(new ReturnParticipantEventsDTO(participant), HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        try {
            var participant = partEvenService.findById(id);
            return new ResponseEntity<>(new ReturnParticipantEventsDTO(participant), HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findall")
    public ResponseEntity findAll() {
        try {
            List<ParticipantsEventsEntity> participants= partEvenService.findAll();
            return new ResponseEntity<>(participants.stream()
                    .map(ReturnParticipantEventsDTO::new)
                    .collect(Collectors.toList()), HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<? extends Object> delete(@PathVariable Long id){
        try {
            var participant = partEvenService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

}
