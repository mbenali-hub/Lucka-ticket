package com.benali.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.benali.feign.PaymentFeignClient;
import com.benali.model.CreditCardDTO;
import com.benali.model.PaymentResponse;
import com.benali.service.PurchaseService;

import lombok.RequiredArgsConstructor;

//@RequiredArgsConstructor
@Service
public class PurchaseServiceImpl implements PurchaseService{

    @Autowired
    private PaymentFeignClient paymentFeignClient;
    @Override
    public PaymentResponse buyTickets(String mail, Long eventId, CreditCardDTO card) throws Exception {
        System.out.println("Haciendo post con : "+ mail + " || " + eventId + " || "+ card.toString()) ;
        PaymentResponse response = paymentFeignClient.makeAPurchase(mail,eventId,card);
        if (response != null) return response;
        else throw new Exception();
    }


}
