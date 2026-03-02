package com.benali.controller;

import java.net.http.HttpHeaders;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.benali.model.AuthenticationResponse;
import com.benali.model.CreditCardDTO;
import com.benali.model.PaymentResponse;
import com.benali.model.PaymentRequest;
import com.benali.service.PurchaseService;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;

@RestController
//@RequiredArgsConstructor
@RequestMapping("/purchase")
public class PurchaseController {
    private static final Logger logger = LoggerFactory.getLogger(PurchaseController.class);
    @Autowired
    private PurchaseService purchaseService;

    @PostMapping()
    public ResponseEntity<PaymentResponse> buyTickets(@RequestParam String mail, @RequestParam Long eventId, @RequestBody PaymentRequest petition){

        PaymentResponse response = purchaseService.buyTickets(mail, eventId, petition);
         logger.debug("Respuesta a la compra: {}", response);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/validate")
    public ResponseEntity<AuthenticationResponse> validateUser(@RequestParam String user, @RequestParam String password){

        AuthenticationResponse authResponse = purchaseService.validateUser(user, password);
        logger.debug("Respuesta al auth: {}", authResponse);
        return ResponseEntity.ok(authResponse);
    }

}
