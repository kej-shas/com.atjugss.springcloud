package com.atjugss.springcloud.dao;

import com.atjugss.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {
    public Payment getPayById(@Param("id") int id);
    public int create(Payment payment);
}
