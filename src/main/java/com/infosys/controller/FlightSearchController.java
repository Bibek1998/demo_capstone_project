package com.infosys.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.dto.FlightDetailsDTO;
import com.infosys.service.FlightService;

@RestController
@RequestMapping("/flight")
@Validated
public class FlightSearchController 
{
	@Autowired
	FlightService flightService;
	
	@GetMapping("/source")
	public List<String> getAllSourceFlight()
	{
		return flightService.getAllSourceFlight();
	}
	@GetMapping("/destination")
	public List<String> getAllDestinationFlight()
	{
		return flightService.getAllDestinationFlight();
	}
	@PostMapping
	public List<FlightDetailsDTO> getflightDetailsWithMoreQuerys(@RequestParam("source") 
	@Pattern(regexp = "[A-Z][a-z]*", message = "{message.flight.source.property}") String source, 
	@RequestParam("destination") @Pattern(regexp = "[A-Z][a-z]*", message = "{message.flight.destination.property}")
	String destination, @RequestParam("date") @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "{message.flight.date.property}")
	String date,@RequestParam(value = "departure", required = false) String departure,
	@RequestParam(value = "airlines", required =  false) String airlines,
	@RequestParam(value = "price", required = false) Double price)
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate availableDate = LocalDate.parse(date, formatter);
		if(departure == null && airlines == null && price == null)
		{
			return flightService.getFlightDetails(source, destination, availableDate);
		}
		else if(departure != null && airlines == null && price == null)
		{
			return flightService.getFlightDetails1(source, destination, availableDate, departure);
		}
		else if(departure == null && airlines != null && price == null)
		{
			return flightService.getFlightDetails2(source, destination, availableDate, airlines);
		}
		else if(departure == null && airlines == null && price != null)
		{
			return flightService.getFlightDetails3(source, destination, availableDate, price);
		}
		else if(departure != null && airlines != null && price == null)
		{
			return flightService.getFlightDetails4(source, destination, availableDate, departure, airlines);
		}
		else if(departure == null && airlines != null && price != null)
		{
			return flightService.getFlightDetails5(source, destination, availableDate, airlines, price);
		}
		else if(departure != null && airlines == null && price != null)
		{
			return flightService.getFlightDetails6(source, destination, availableDate, departure, price);
		}
		else
			return flightService.getFlightDetails7(source, destination, availableDate, departure, airlines, price);
	}
}
