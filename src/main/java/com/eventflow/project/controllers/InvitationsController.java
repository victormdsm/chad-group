package com.eventflow.project.controllers;


import com.eventflow.project.dto.invitationsdto.InvitationCreateDTO;
import com.eventflow.project.dto.invitationsdto.ReturnInvitationDataDTO;
import com.eventflow.project.dto.participantsdto.ReturnParticipantDataDTO;
import com.eventflow.project.entities.InvitationsEntity;
import com.eventflow.project.entities.ParticipantsEntity;
import com.eventflow.project.services.InvitationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.eventflow.project.mapper.InvitationMapper.InvitationCreatDTOtoInvitationEntity;
import static com.eventflow.project.mapper.ParticipantMapper.ParticipantDtoParticipantEntity;

@RestController
@RequestMapping("api/invitation")
public class InvitationsController {

    @Autowired
    InvitationsService invitationsService;

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody InvitationCreateDTO dto){
        try {
            var invite = InvitationCreatDTOtoInvitationEntity(dto);
            invitationsService.save(invite);
            return new ResponseEntity<>(new ReturnInvitationDataDTO(invite), HttpStatus.CREATED);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        try {
            var invite = invitationsService.findById(id);
            return new ResponseEntity<>(new ReturnInvitationDataDTO(invite), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findall")
    public ResponseEntity<List<ReturnInvitationDataDTO>> findAll(){
        try {
            List<InvitationsEntity> invites = invitationsService.findAll();
            return new ResponseEntity<>(invites.stream()
                    .map(ReturnInvitationDataDTO::new)
                    .collect(Collectors.toList()), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null ,HttpStatus.BAD_REQUEST);
        }
    }


}
