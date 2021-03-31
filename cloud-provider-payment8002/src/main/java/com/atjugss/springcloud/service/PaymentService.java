package com.atjugss.springcloud.service;

import com.atjugss.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    public Payment getPayById(@Param("id") int id);
    public int create(Payment payment);
}
