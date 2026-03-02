package com.benali.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class AditionalInfoResponse {

    @NotBlank
    private String emisor;
    @NotBlank
    private String concepto;
    @NotBlank
    private String cantidad;
}
