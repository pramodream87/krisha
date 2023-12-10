package com.krisha.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krisha.entity.PaymentInfo;

public interface PaymentInfoRepository  extends JpaRepository<PaymentInfo, String>{

}
