package com.infosys.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.dto.FlightDetailsDTO;
import com.infosys.entity.FlightDetails;
import com.infosys.repository.FlightDetailsRepository;

@Service
public class FlightService {
	@Autowired
	FlightDetailsRepository flightRepository;

	public List<FlightDetailsDTO> getFlightDetails(String source, String destination, LocalDate availableDate) {
		Iterable<FlightDetails> it = flightRepository.findBySourceAndDestinationAndFlightAvailableDate(source,
				destination, availableDate);
		List<FlightDetails> list = new ArrayList<>();
		it.forEach(flight -> list.add(flight));
		List<FlightDetailsDTO> list2 = new ArrayList<>();
		list.forEach(flight -> list2.add(FlightDetailsDTO.convertEntitytoDTO(flight)));
		return list2;
	}

	public List<FlightDetailsDTO> getFlightDetails1(String source, String destination, LocalDate availableDate,
			String departure) 
	{
		Iterable<FlightDetails> it = flightRepository.findBySourceAndDestinationAndFlightAvailableDateAndDepartureTime(source,
				destination, availableDate, departure);
		List<FlightDetails> list = new ArrayList<>();
		it.forEach(flight -> list.add(flight));
		List<FlightDetailsDTO> list2 = new ArrayList<>();
		list.forEach(flight -> list2.add(FlightDetailsDTO.convertEntitytoDTO(flight)));
		return list2;
	}

	public List<FlightDetailsDTO> getFlightDetails2(String source, String destination, LocalDate availableDate,
			String airlines) 
	{
		Iterable<FlightDetails> it = flightRepository.findBySourceAndDestinationAndFlightAvailableDateAndAirlines(source,
				destination, availableDate, airlines);
		List<FlightDetails> list = new ArrayList<>();
		it.forEach(flight -> list.add(flight));
		List<FlightDetailsDTO> list2 = new ArrayList<>();
		list.forEach(flight -> list2.add(FlightDetailsDTO.convertEntitytoDTO(flight)));
		return list2;
	}

	public List<FlightDetailsDTO> getFlightDetails3(String source, String destination, LocalDate availableDate,
			Double price) 
	{
		Iterable<FlightDetails> it = flightRepository.findBySourceAndDestinationAndFlightAvailableDateAndFareLessThanEqual(source,
				destination, availableDate, price);
		List<FlightDetails> list = new ArrayList<>();
		it.forEach(flight -> list.add(flight));
		List<FlightDetailsDTO> list2 = new ArrayList<>();
		list.forEach(flight -> list2.add(FlightDetailsDTO.convertEntitytoDTO(flight)));
		return list2;
	}

	public List<FlightDetailsDTO> getFlightDetails4(String source, String destination, LocalDate availableDate,
			String departure, String airlines) 
	{
		Iterable<FlightDetails> it = flightRepository.findBySourceAndDestinationAndFlightAvailableDateAndDepartureTimeAndAirlines
		(source,destination, availableDate, departure, airlines);
		List<FlightDetails> list = new ArrayList<>();
		it.forEach(flight -> list.add(flight));
		List<FlightDetailsDTO> list2 = new ArrayList<>();
		list.forEach(flight -> list2.add(FlightDetailsDTO.convertEntitytoDTO(flight)));
		return list2;
	}

	public List<FlightDetailsDTO> getFlightDetails5(String source, String destination, LocalDate availableDate,
			String airlines, Double price) 
	{
		Iterable<FlightDetails> it = flightRepository.findBySourceAndDestinationAndFlightAvailableDateAndAirlinesAndFareLessThanEqual
		(source,destination, availableDate, airlines, price);
		List<FlightDetails> list = new ArrayList<>();
		it.forEach(flight -> list.add(flight));
		List<FlightDetailsDTO> list2 = new ArrayList<>();
		list.forEach(flight -> list2.add(FlightDetailsDTO.convertEntitytoDTO(flight)));
		return list2;
	}

	public List<FlightDetailsDTO> getFlightDetails6(String source, String destination, LocalDate availableDate,
			String departure, Double price) 
	{
		Iterable<FlightDetails> it = flightRepository.findBySourceAndDestinationAndFlightAvailableDateAndDepartureTimeAndFareLessThanEqual
		(source,destination, availableDate, departure, price);
		List<FlightDetails> list = new ArrayList<>();
		it.forEach(flight -> list.add(flight));
		List<FlightDetailsDTO> list2 = new ArrayList<>();
		list.forEach(flight -> list2.add(FlightDetailsDTO.convertEntitytoDTO(flight)));
		return list2;
	}

	public List<FlightDetailsDTO> getFlightDetails7(String source, String destination, LocalDate availableDate,
			String departure, String airlines, Double price) 
	{
		Iterable<FlightDetails> it = flightRepository.findBySourceAndDestinationAndFlightAvailableDateAndDepartureTimeAndAirlinesAndFareLessThanEqual
		(source,destination, availableDate, departure, airlines, price);
		List<FlightDetails> list = new ArrayList<>();
		it.forEach(flight -> list.add(flight));
		List<FlightDetailsDTO> list2 = new ArrayList<>();
		list.forEach(flight -> list2.add(FlightDetailsDTO.convertEntitytoDTO(flight)));
		return list2;
	}

	public List<String> getAllSourceFlight() {
		List<String> list = flightRepository.findAllSource();
		return list;
	}
	public List<String> getAllDestinationFlight() {
		List<String> list = flightRepository.findAllDestination();
		return list;
	}
}
