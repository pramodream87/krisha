package com.krisha.dto;

import java.sql.Date;

import com.krisha.entity.PassengerInfo;
import com.krisha.entity.PaymentInfo;
import com.krisha.repository.PassengerInfoRepository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingRequest {

	private PassengerInfo passengerInfo;
	private PaymentInfo paymentInfo;
}
