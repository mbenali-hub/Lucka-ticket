package com.benali.service.impl;

import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.Map;

import org.apache.catalina.filters.HttpHeaderSecurityFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.util.MultiValueMapAdapter;

import com.benali.config.TokenContext;
import com.benali.feign.PaymentFeignClient;
import com.benali.model.AuthenticationResponse;
import com.benali.model.CreditCardDTO;
import com.benali.model.PaymentResponse;
import com.benali.model.PaymentRequest;
import com.benali.service.PurchaseService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PurchaseServiceImpl implements PurchaseService{

    
    private final PaymentFeignClient paymentFeignClient;
    //private final TokenContext tokenContext;
    private static final Logger logger = LoggerFactory.getLogger(PurchaseServiceImpl.class);
    private final HttpServletRequest request;
    @Override
    public PaymentResponse buyTickets(String mail, Long eventId, PaymentRequest petition){
        System.out.println("Haciendo post con : "+ mail + " || " + eventId + " || "+ petition.toString()) ;
        PaymentResponse response = null;
        try {        
            response = paymentFeignClient.makeAPurchase(mail,eventId,petition);    
            System.out.println("Respuesta recibida: "+ response);
        } catch (Exception e) {
            System.out.println("Excepci9nnn "+  e.getMessage());
        } 
        return response;
    }

    @Override
    public AuthenticationResponse validateUser(String user, String password){

        AuthenticationResponse authResponse = null;
        try {
            logger.debug("Antes de hacer post con : {} || {}", user, password);
            //logger.debug("EL TOKEN: {}", tokenContext.getToken());
            logger.debug("Hilo actual en service: {}", Thread.currentThread().getName());
           authResponse = paymentFeignClient.validateUser(user, password);
           System.out.println("Haciendo post con : "+ user + " || " + password) ;
        } catch (Exception e) {
            System.out.println("Excepci9nnn "+  e.getMessage());
        }
        return authResponse;
    }

   
}
