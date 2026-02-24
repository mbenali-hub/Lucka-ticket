package com.benali.mapper;

import org.mapstruct.Mapper;

import com.benali.entity.Event;
import com.benali.model.EventDTO;

@Mapper( componentModel = "spring")
public interface EventMapper  {
    EventDTO tDto (Event event);
    Event toEntity (EventDTO eventDTO);
}
