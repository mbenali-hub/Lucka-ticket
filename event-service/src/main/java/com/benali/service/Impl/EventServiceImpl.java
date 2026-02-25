package com.benali.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.benali.entity.Event;
import com.benali.mapper.EventMapper;
import com.benali.model.EventDTO;
import com.benali.repository.EventRepository;
import com.benali.service.EventService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService{


    private final EventRepository eventRepository;
    private final EventMapper eventMapper;
    @Override
    public EventDTO registerEvent(EventDTO eventDTO) {

        Event event = eventMapper.toEntity(eventDTO);

        if(event.getId()==null && !eventRepository.existsByName(eventDTO.getName())){
            event = eventRepository.save(event);
        }
        else{
            //throw new EventNameAlreadyExistsException();
        }
        return eventMapper.tDto(event);
    }

    @Override
    public EventDTO showEventDetails(Long eventId) {

        Event event = getEventOrThrowException(eventId);
        return eventMapper.tDto(event);
    }

    
    @Override
    public EventDTO updateEvent(EventDTO eventDTO, Long eventId) {
        
        Event event = getEventOrThrowException(eventId);
        eventDTO.setId(eventId);
        event = eventRepository.save(eventMapper.toEntity(eventDTO));
        return eventMapper.tDto(event);       
    }
    
    @Override
    public EventDTO deleteEvent(Long eventId) {
        
        Event event = getEventOrThrowException(eventId);
        event.setDeleted(true);
        eventRepository.save(event);
        return eventMapper.tDto(event);
    }
    
    @Override
    public List<EventDTO> listEvents() {
        List<Event> events = eventRepository.findAll();
        List<EventDTO> eventsDto = events.stream()
        .map(eventMapper::tDto)
        .toList();
        return eventsDto;
    }

    private Event getEventOrThrowException(Long eventId) {

        Event event = eventRepository.findById(eventId).orElseThrow();
        return event;
    }
                                    
}
