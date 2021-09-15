package com.infosys.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.dto.BookedInfoDTO;
import com.infosys.dto.PassengerDetailsDTO;
import com.infosys.exception.BookingUnsuccessfullException;
import com.infosys.service.BookingService;

@RestController
@RequestMapping("/booking")
@Validated
public class BookingController 
{
	@Autowired
	BookingService bookingService;
	
	@PostMapping
	public ResponseEntity<BookedInfoDTO> bookTicket(@RequestParam("flightId") 
	@Pattern(regexp = "F[\\d]{0,4}", message = "{message.flight.id.property}") String flightId,
	@RequestParam("userId") @Pattern(regexp = "C100[\\d]{1,3}", message = "{message.id.property}")
	String userId, @Valid @RequestBody List<PassengerDetailsDTO> passengerList) throws BookingUnsuccessfullException
	{
		return bookingService.bookTicket(flightId, userId, passengerList);
	}
}
