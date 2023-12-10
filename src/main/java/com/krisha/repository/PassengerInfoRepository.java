package com.krisha.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krisha.entity.PassengerInfo;

public interface PassengerInfoRepository extends JpaRepository<PassengerInfo, Long> {

}
