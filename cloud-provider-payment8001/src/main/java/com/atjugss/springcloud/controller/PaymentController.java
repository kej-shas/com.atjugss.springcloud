package com.atjugss.springcloud.controller;

import com.atjugss.springcloud.entities.CommonResult;
import com.atjugss.springcloud.entities.Payment;
import com.atjugss.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class PaymentController {
    @Resource
    PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/")
    public Object getInfo(){
        return discoveryClient.getInstances("cloud-payment-service");
    }

    @GetMapping(value = "pay/get/{id}")
    public CommonResult getPayment(@PathVariable("id") int id) {
        return new CommonResult<Payment>(200, "成功" + port, paymentService.getPayById(id));
    }

    @PostMapping(value = "pay/create")
    public CommonResult create(@RequestBody Payment payment) {
        return new CommonResult(200, "成功", paymentService.create(payment));
    }
}

