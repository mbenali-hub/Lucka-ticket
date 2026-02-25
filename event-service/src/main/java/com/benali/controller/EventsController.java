package com.benali.controller;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.benali.model.EventDTO;
import com.benali.service.EventService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/events" )
@RequiredArgsConstructor
public class EventsController {

    private final EventService eventService;
    @GetMapping
    public ResponseEntity<List<EventDTO>> getAllEvents(){
        List<EventDTO> events = eventService.listEvents();
        return ResponseEntity.ok(events);
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<EventDTO> getEvent(@PathVariable Long eventId){
        EventDTO event = eventService.showEventDetails(eventId);
        return ResponseEntity.ok(event);
    }

    @PostMapping
    public ResponseEntity<EventDTO> createEvent(@Valid @RequestBody EventDTO eventDTO){
       EventDTO event = eventService.registerEvent(eventDTO);
       return new ResponseEntity<>(event,HttpStatus.CREATED);
    }

    @PutMapping("/{eventId}")
    public ResponseEntity<EventDTO> updateEvent(@Valid @RequestBody EventDTO eventDTO, @PathVariable Long eventId){
        EventDTO event = eventService.updateEvent(eventDTO, eventId);
        return ResponseEntity.ok(event);
    }

    @DeleteMapping("/{eventId}")
    public ResponseEntity<EventDTO> deleteEvent (@PathVariable Long eventId){
        EventDTO event = eventService.deleteEvent(eventId);
        return ResponseEntity.ok(event);
    }
}
