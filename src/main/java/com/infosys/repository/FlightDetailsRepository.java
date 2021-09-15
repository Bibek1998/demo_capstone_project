package com.infosys.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.infosys.entity.FlightDetails;

public interface FlightDetailsRepository extends JpaRepository<FlightDetails, String>
{
	public List<FlightDetails> findBySourceAndDestinationAndFlightAvailableDate(String source, String destination, LocalDate flightAvailableDate);
	public List<FlightDetails> findBySourceAndDestinationAndFlightAvailableDateAndDepartureTime(String source, String destination, LocalDate flightAvailableDate, String departureTime);
	public List<FlightDetails> findBySourceAndDestinationAndFlightAvailableDateAndAirlines(String source, String destination, LocalDate flightAvailableDate, String airlines);
	public List<FlightDetails> findBySourceAndDestinationAndFlightAvailableDateAndFareLessThanEqual(String source, String destination, LocalDate flightAvailableDate, Double fare);
	public List<FlightDetails> findBySourceAndDestinationAndFlightAvailableDateAndDepartureTimeAndAirlines(String source, String destination, LocalDate flightAvailableDate, String departureTime, String airlines);
	public List<FlightDetails> findBySourceAndDestinationAndFlightAvailableDateAndAirlinesAndFareLessThanEqual(String source, String destination, LocalDate flightAvailableDate, String airlines, Double price);
	public List<FlightDetails> findBySourceAndDestinationAndFlightAvailableDateAndDepartureTimeAndFareLessThanEqual(String source, String destination, LocalDate flightAvailableDate, String departureTime, Double price);
	public List<FlightDetails> findBySourceAndDestinationAndFlightAvailableDateAndDepartureTimeAndAirlinesAndFareLessThanEqual(String source, String destination, LocalDate flightAvailableDate, String departureTime, String airlines, Double price);
	
	@Query(value = "select source from flight_details", nativeQuery = true)
	public List<String> findAllSource();
	
	@Query(value = "select destination from flight_details", nativeQuery = true)
	public List<String> findAllDestination();
}
