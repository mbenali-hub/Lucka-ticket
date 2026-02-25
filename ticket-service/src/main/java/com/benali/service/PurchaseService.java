package com.benali.service;

import com.benali.model.CreditCardDTO;
import com.benali.model.PaymentResponse;

public interface PurchaseService {
    PaymentResponse buyTickets(String mail, Long eventId, CreditCardDTO card) throws Exception;
}
