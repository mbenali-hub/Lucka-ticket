package com.benali.unitTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import javax.naming.spi.DirStateFactory.Result;

import org.h2.command.dml.MergeUsing.When;
import org.hibernate.mapping.Any;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.benali.entity.Event;
import com.benali.mapper.EventMapper;
import com.benali.mapper.EventMapperImpl;
import com.benali.model.EventDTO;
import com.benali.model.EventDTO.STATUS;
import com.benali.repository.EventRepository;
import com.benali.service.EventService;
import com.benali.service.impl.EventServiceImpl;

@ExtendWith(MockitoExtension.class)
public class EvetnServiceTest {
    
    @Mock
    private EventRepository eventRepository;

    @InjectMocks
    private EventServiceImpl eventService;

    //@Autowired
    @Mock
    private EventMapper eventMapper = new EventMapperImpl();


    @Test
    public void shouldReturnEvent_whenIdEventExists(){
        Event event = Event.builder()
                            .id(1L)
                            .name("TEST EVENT")
                            .description("A test")
                            .build();
        EventDTO eventDTO = EventDTO.builder()
                                    .id(1L)
                                    .name("TEST EVENT")
                                    .description("A test")
                                    .build();
        
        when(eventRepository.findById(1L)).thenReturn(Optional.of(event));
        when(eventMapper.tDto(event)).thenReturn(eventDTO);

        EventDTO result = eventService.showEventDetails(1L);
        
        assertNotNull(result);
    }

    @Test
    public void shouldThrowException_whenIdDoesNotExists(){}

    @Test
    public void shouldRegisterEvent_whenIdIsNullAndNameIsUnique(){
        Event event = Event.builder()
                        .id(null)
                        .name("TEST EVENT")
                        .description("A test")
                        .build();
        EventDTO eventDTO = EventDTO.builder()
                                    .id(null)
                                    .name("TEST EVENT")
                                    .description("A test")
                                    .build();

        when(eventRepository.existsByName(eventDTO.getName())).thenReturn(false);
        when(eventRepository.save(event)).thenReturn(event);
        when(eventMapper.toEntity(eventDTO)).thenReturn(event);
        when(eventMapper.tDto(event)).thenReturn(eventDTO);

        
        EventDTO result = eventService.registerEvent(eventDTO);
        
        assertNotNull(result);
        assertEquals("TEST EVENT", result.getName());

        verify(eventRepository).save(event);
    }

    @Test
    public void shouldThrowException_whenNameIsNotUnique(){}

    @Test
    public void shouldThrowException_whenIdEventExists(){}

}
