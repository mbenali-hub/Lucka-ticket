package com.benali.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@Builder
public class CreditCardDTO {
    private String nombreTitular;
    private String numeroTarjeta;
    private Integer mesCaducidad;
    private Integer yearCaducidad;
    private Integer cvv;
    private String enmisor;
    private String concepto;
    private String cantidad;
}
