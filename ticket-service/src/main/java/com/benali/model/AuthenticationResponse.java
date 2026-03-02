package com.benali.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
@AllArgsConstructor
public class AuthenticationResponse {
    private String user;
    private String pwd;
    private String token;
}
