package com.benali.service;

import java.util.List;

import com.benali.model.EventDTO;

public interface EventService {
    EventDTO registerEvent (EventDTO eventDTO);
    EventDTO showEventDetails(Long eventId);
    EventDTO updateEvent(EventDTO eventDTO,Long eventId);
    EventDTO deleteEvent(Long eventId);
    List<EventDTO> listEvents();
 
}
