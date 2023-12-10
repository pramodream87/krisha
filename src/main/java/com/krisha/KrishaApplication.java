package com.krisha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.krisha.dto.FlightBookingAcknowledgement;
import com.krisha.dto.FlightBookingRequest;
import com.krisha.service.FlightBookingService;

@SpringBootApplication
@RestController
@EnableTransactionManagement
public class KrishaApplication {
	@Autowired
	private FlightBookingService service;

	public static void main(String[] args) {
		SpringApplication.run(KrishaApplication.class, args);
	}

	
	@PostMapping("/bookFlightTicket")
	public FlightBookingAcknowledgement bookFlightTicket(@RequestBody FlightBookingRequest request) {
		return service.bookFlightTicket(request);
	}
	
	@GetMapping("/getBookFlightTicket/{pid}")
	public FlightBookingRequest getBookFlightTicket(Long pid) {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>pid ="+pid);
		return service.getBookFlightTicket(pid);
	}
	// public FlightBookingRequest getUserById(Long pId) {
}
