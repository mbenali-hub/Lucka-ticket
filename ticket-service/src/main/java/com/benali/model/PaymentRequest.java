package com.benali.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
public class PaymentRequest {
    
    private String nombreTitular;
    private String numeroTarjeta;
    private Integer mesCaducidad;
    private Integer yearCaducidad;
    private Integer cvv;

    @NotBlank
    private String emisor;
    @NotBlank
    private String concepto;
    @NotBlank
    private String cantidad;
}
