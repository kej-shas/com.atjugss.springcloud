package com.atjugss.springcloud.controller;

import com.atjugss.springcloud.entities.CommonResult;
import com.atjugss.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {
    public static final String Payment_Url="http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    public RestTemplate restTemplate;

    @GetMapping(value = "user/pay/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") int id){
        return restTemplate.getForObject(Payment_Url+"/pay/get/"+id,CommonResult.class,id);
    }
    @GetMapping(value = "user/pay/create")
    public CommonResult createPayment(Payment payment){
        return restTemplate.postForObject(Payment_Url+"/pay/create",payment,CommonResult.class);
    }
}
