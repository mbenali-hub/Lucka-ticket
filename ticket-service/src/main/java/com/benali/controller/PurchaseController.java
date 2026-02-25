package com.benali.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.benali.model.CreditCardDTO;
import com.benali.model.PaymentResponse;
import com.benali.service.PurchaseService;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;

@RestController
//@RequiredArgsConstructor
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping()
    public ResponseEntity<PaymentResponse> buyTickets(@RequestParam String mail, @RequestParam Long eventId, @RequestBody CreditCardDTO card){
        PaymentResponse response = null;
        try {
            response = purchaseService.buyTickets(mail, eventId, card);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ResponseEntity.ok(response);
    }

}
