package com.krisha.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.krisha.dto.FlightBookingAcknowledgement;
import com.krisha.dto.FlightBookingRequest;
import com.krisha.entity.PassengerInfo;
import com.krisha.entity.PaymentInfo;
import com.krisha.repository.PassengerInfoRepository;
import com.krisha.repository.PaymentInfoRepository;
import com.krisha.utils.PaymentUtils;

@Service
public class FlightBookingService {

	@Autowired
	private PassengerInfoRepository passengerInfoRepository;
	
	@Autowired
	private PaymentInfoRepository paymentInfoRepository;
	
	@Transactional
	public FlightBookingAcknowledgement bookFlightTicket(FlightBookingRequest request) {
		
		
		FlightBookingAcknowledgement acknowledgement = null;
		PassengerInfo passengerInfo = request.getPassengerInfo();
		
		passengerInfo = passengerInfoRepository.save(passengerInfo);
		
		PaymentInfo paymentInfo = request.getPaymentInfo();
				
		PaymentUtils.validateCreditlimit(paymentInfo.getAccountNo(), passengerInfo.getFare());
		paymentInfo.setPassengerId(passengerInfo.getPId());
		paymentInfo.setAmount(passengerInfo.getFare());
		paymentInfoRepository.save(paymentInfo);
		
		return new FlightBookingAcknowledgement("SUCCESS",passengerInfo.getFare(),UUID.randomUUID().toString().split("-")[0], passengerInfo);
	}
	
	  
	    public FlightBookingRequest getBookFlightTicket(Long pId) {
	    	System.out.println("servcice>>>>>>>>>>>>>>>>>>>>>>>>>>pid ="+pId);
	        Optional<PassengerInfo> passengerInfo = passengerInfoRepository.findById(pId);
	       // Optional<PaymentInfo> paymentInfo = paymentInfoRepository.
	        System.out.println("data =========fare = "+passengerInfo.get().getFare());
	        FlightBookingRequest flightBookingRequest = new FlightBookingRequest();
	        flightBookingRequest.setPassengerInfo(passengerInfo.get());
	        return flightBookingRequest;
	    }
}
