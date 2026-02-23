package com.benali.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.benali.model.EventDTO;
import com.benali.repository.EventRepository;
import com.benali.service.EventService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService{


    private final EventRepository eventRepository;
    @Override
    public EventDTO registerEvent(EventDTO eventDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'registerEvent'");
    }

    @Override
    public EventDTO showEventDetails(Long eventId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'showEventDetails'");
    }

    @Override
    public EventDTO updateEvent(EventDTO eventDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateEvent'");
    }

    @Override
    public EventDTO deleteEvent(Long eventId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteEvent'");
    }

    @Override
    public List<EventDTO> listEvents() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listEvents'");
    }

}
