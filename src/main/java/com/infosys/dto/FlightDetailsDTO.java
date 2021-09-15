package com.infosys.dto;

import java.time.LocalDate;

import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.infosys.entity.FlightDetails;

public class FlightDetailsDTO 
{
	@Pattern(regexp = "F(\\d){3,20}", message = "{message.flight.id.property}")
	private String flightId;
	private String airlines;
	@Pattern(regexp = "[A-Z](a-z)*", message = "{message.flight.source.property}")
	private String source;
	@Pattern(regexp = "[A-Z](a-z)*", message = "{message.flight.destination.property}")
	private String destination;
	
	private Double fare;
	@DateTimeFormat
	private LocalDate flightAvailableDate;
	private String departureTime;
	private String arrivalTime;
	private int seatCount;
	
	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public String getAirlines() {
		return airlines;
	}

	public void setAirlines(String airlines) {
		this.airlines = airlines;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Double getFare() {
		return fare;
	}

	public void setFare(Double fare) {
		this.fare = fare;
	}

	public LocalDate getFlightAvailableDate() {
		return flightAvailableDate;
	}

	public void setFlightAvailableDate(LocalDate flightAvailableDate) {
		this.flightAvailableDate = flightAvailableDate;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getSeatCount() {
		return seatCount;
	}

	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}

	@Override
	public String toString() {
		return "FlightDetailsDTO [flightId=" + flightId + ", airlines=" + airlines + ", source=" + source
				+ ", destination=" + destination + ", fare=" + fare + ", flightAvailableDate=" + flightAvailableDate
				+ ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", seatCount=" + seatCount
				+ "]";
	}
	public FlightDetails prepareFlightDetailsEntity() 
	{
		FlightDetails flightDetails = new FlightDetails();
		flightDetails.setFlightId(this.getFlightId());
		flightDetails.setAirlines(this.getAirlines());
		flightDetails.setSource(this.getSource());
		flightDetails.setDestination(this.getDestination());
		flightDetails.setFare(this.getFare());
		flightDetails.setFlightAvailableDate(this.getFlightAvailableDate());
		flightDetails.setDepartureTime(this.getDepartureTime());
		flightDetails.setArrivalTime(this.getArrivalTime());
		flightDetails.setSeatCount(this.getSeatCount());
		return flightDetails;
	}
	public static FlightDetailsDTO convertEntitytoDTO(FlightDetails flight)
	{
		FlightDetailsDTO flightDetails = new FlightDetailsDTO();
		flightDetails.setFlightId(flight.getFlightId());
		flightDetails.setAirlines(flight.getAirlines());
		flightDetails.setSource(flight.getSource());
		flightDetails.setDestination(flight.getDestination());
		flightDetails.setFare(flight.getFare());
		flightDetails.setFlightAvailableDate(flight.getFlightAvailableDate());
		flightDetails.setDepartureTime(flight.getDepartureTime());
		flightDetails.setArrivalTime(flight.getArrivalTime());
		flightDetails.setSeatCount(flight.getSeatCount());
		return flightDetails;
	}
	
}
