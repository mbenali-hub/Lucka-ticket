package com.benali.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.benali.model.CreditCardDTO;
import com.benali.model.PaymentResponse;

import lombok.AllArgsConstructor;

@FeignClient(name = "paymentClient", url = "http://lucabanking.us-east-1.elasticbeanstalk.com" )
public interface PaymentFeignClient {

    //@PostMapping("/pasarela/validación")
    @PostMapping("/pasarela/compra")
    public PaymentResponse makeAPurchase(@RequestParam String mail, @RequestParam Long ID, @RequestBody CreditCardDTO card);

    @PostMapping("/pasarela/validaruser")
    public void validateUser(@RequestParam String user, @RequestParam String password);
}
