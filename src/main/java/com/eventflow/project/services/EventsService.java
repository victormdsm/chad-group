package com.eventflow.project.services;

import com.eventflow.project.dto.eventsdto.CreatEventDTO;
import com.eventflow.project.dto.eventsdto.EventDTO;
import com.eventflow.project.dto.eventsdto.ReturnEventDataDTO;
import com.eventflow.project.entities.EventsEntitiy;
import com.eventflow.project.entities.UsersEntity;
import com.eventflow.project.repositories.EventsRepository;
import com.eventflow.project.repositories.UsersRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventsService {

    @Autowired
    private EventsRepository eventsRepository;
    @Autowired
    private UsersRepository usersRepository;

    public ReturnEventDataDTO save(@Valid CreatEventDTO creatEventDTO) {
        UsersEntity user = usersRepository.findById(creatEventDTO.userID())
                .orElseThrow(() -> new RuntimeException("User not found"));
        EventsEntitiy eventsEntitiy = new EventsEntitiy(creatEventDTO, user);
        EventsEntitiy eventoSalvo = this.eventsRepository.save(eventsEntitiy);
        return new ReturnEventDataDTO(eventoSalvo);
    }

    public ReturnEventDataDTO update(@Valid EventDTO eventDTO) {
        EventsEntitiy existingEvent = eventsRepository.findById(eventDTO.getId())
                .orElseThrow(() -> new RuntimeException("Event not found"));
        existingEvent.setTitle(eventDTO.getTitle());
        existingEvent.setDescription(eventDTO.getDescription());
        existingEvent.setStartDateTime(eventDTO.getStartDateTime());
        existingEvent.setEndDateTime(eventDTO.getEndDateTime());
        existingEvent.setLocation(eventDTO.getLocation());
        existingEvent.setCapacity(eventDTO.getCapacity());
        EventsEntitiy updatedEvent = eventsRepository.save(existingEvent);
        return new ReturnEventDataDTO(updatedEvent);
    }

    public String delete(@Valid Long id){
        if (eventsRepository.existsById(id)){
            eventsRepository.deleteById(id);
            return "Evento Excluido";
        }
        return "Evento não encontrado";
    }

    public ReturnEventDataDTO findById(Long id) {
        EventsEntitiy event = eventsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));
        return new ReturnEventDataDTO(event);
    }

    public List<ReturnEventDataDTO> findAll() {
        List<EventsEntitiy> events = eventsRepository.findAll();
        return events.stream()
                .map(ReturnEventDataDTO::new) // Converte cada evento para o DTO
                .collect(Collectors.toList());
    }
}
