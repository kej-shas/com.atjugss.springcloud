package com.atjugss.springcloud.service.impl;

import com.atjugss.springcloud.dao.PaymentDao;
import com.atjugss.springcloud.entities.Payment;
import com.atjugss.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    PaymentDao paymentDao;

    @Override
    public Payment getPayById(int id) {
        return paymentDao.getPayById(id);
    }

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }
}
