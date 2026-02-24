package com.benali.model;

import java.time.LocalDate;
import java.time.LocalTime;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Builder
public class EventDTO {
    
    public enum STATUS {ACTIVE, FINISHED, CANCELED}
    public enum TYPEEVENT {SOCIAL, CORPORATE, CULTURAL, SPORTING, ENTERTAINMENT}

    private Long id;

    private String name;

    private String description;

    private LocalDate date;

    private LocalTime time;

    private Double minPrice;

    private Double maxPrice;

    private String town;

    private TYPEEVENT type;

    private STATUS status;

    private boolean deleted;

}
