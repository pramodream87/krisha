package com.krisha.dto;

import com.krisha.entity.PassengerInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightBookingAcknowledgement {

	private  String status;
	private double totalFare;
	private String pnrNo;
	private PassengerInfo passengerInfo;
}
