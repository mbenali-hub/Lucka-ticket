package com.benali.service;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.benali.model.AuthenticationResponse;
import com.benali.model.CreditCardDTO;
import com.benali.model.PaymentResponse;
import com.benali.model.PaymentRequest;

public interface PurchaseService {

    PaymentResponse buyTickets(String mail, Long eventId, PaymentRequest petition);
    AuthenticationResponse validateUser(@RequestParam String user, @RequestParam String password);
}
