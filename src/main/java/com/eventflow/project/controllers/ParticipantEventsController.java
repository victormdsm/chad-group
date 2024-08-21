package com.eventflow.project.controllers;

import com.eventflow.project.dto.participantsdto.ReturnParticipantDataDTO;
import com.eventflow.project.dto.participantseventsdto.ParticipantEventRegistrationDTO;
import com.eventflow.project.dto.participantseventsdto.ParticipantsEventsUpdateDTO;
import com.eventflow.project.dto.participantseventsdto.ReturnParticipantEventsDTO;
import com.eventflow.project.entities.ParticipantsEventsEntity;
import com.eventflow.project.entities.Status;
import com.eventflow.project.services.ParticipantEventsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.eventflow.project.mapper.ParticipantMapper.ParticipantDtoParticipantEntity;
import static com.eventflow.project.mapper.ParticipantsEventsMapper.participantsEventsDTOtoParticipantsEventsEntity;

@RestController
@RequestMapping("/api/participants-events")
public class ParticipantEventsController {

    @Autowired
    private ParticipantEventsService participantEventsService;


    @PostMapping("/create")
    public ResponseEntity create(@RequestBody @Valid ParticipantEventRegistrationDTO dto) {
        try {
            var participant = participantsEventsDTOtoParticipantsEventsEntity(dto);
            participantEventsService.save(participant);
            return new ResponseEntity<>(new ReturnParticipantEventsDTO(participant), HttpStatus.CREATED);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        try {
            var participant = participantEventsService.findById(id);
            return new ResponseEntity<>(new ReturnParticipantEventsDTO(participant), HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findall")
    public ResponseEntity findAll() {
        try {
            List<ParticipantsEventsEntity> participants= participantEventsService.findAll();
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
            var participant = participantEventsService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/count/confirmed/{eventId}")
    public ResponseEntity<Long> countConfirmedParticipants(@PathVariable Long eventId) {
        long count = participantEventsService.countParticipantsByEventIdAndStatus(eventId, Status.CONFIRMED);
        return ResponseEntity.ok(count);
    }

}
