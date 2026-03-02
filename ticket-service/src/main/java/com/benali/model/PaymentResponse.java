package com.benali.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import tools.jackson.databind.annotation.JsonSerialize;


@Builder
@AllArgsConstructor
@Getter
@Setter
public class PaymentResponse {
    private String timestamp;
    private String status;
    private String error;
    private List<String> message;
    @JsonAlias(value = "info")
    private PaymentRequest paymentRequest;
    private String infoAdicional;
}
