package com.benali.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.benali.config.FeignConfig;
import com.benali.model.AuthenticationResponse;
import com.benali.model.PaymentResponse;

import com.benali.model.PaymentRequest;

@FeignClient(name = "paymentClient", url = "http://lucabanking.us-east-1.elasticbeanstalk.com" , configuration = FeignConfig.class)
public interface PaymentFeignClient {
    
    @PostMapping("/pasarela/validacion")
   //@PostMapping("/pasarela/compra")
    public PaymentResponse makeAPurchase(@RequestParam String mail, @RequestParam Long ID, @RequestBody PaymentRequest petition);

    @PostMapping("/pasarela/validaruser")
    public AuthenticationResponse validateUser(@RequestParam String user, @RequestParam String password);

}
