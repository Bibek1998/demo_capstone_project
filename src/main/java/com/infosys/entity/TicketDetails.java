package com.infosys.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.infosys.dto.TicketDetailsDTO;

@Entity
@Table(name = "ticket_details")
public class TicketDetails 
{
	@Id
	private String pnr;
	private String bookingDate;
	private String departureDate;
	private String departureTime;
	private String totalFare;
	private String flightId;
	private String userId;
	private int noOfSeats;
	
	public String getPnr() {
		return pnr;
	}
	public void setPnr(String pnr) {
		this.pnr = pnr;
	}
	public String getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	public String getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getTotalFare() {
		return totalFare;
	}
	public void setTotalFare(String totalFare) {
		this.totalFare = totalFare;
	}
	public String getFlightId() {
		return flightId;
	}
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public TicketDetailsDTO prepareTicketDetailDTO() 
	{
		TicketDetailsDTO ticket = new TicketDetailsDTO();
		ticket.setPnr(this.getPnr());
		ticket.setBookingDate(this.getBookingDate());
		ticket.setDepartureDate(this.getDepartureDate());
		ticket.setDepartureTime(this.getDepartureTime());
		ticket.setFlightId(this.getFlightId());
		ticket.setUserId(this.getUserId());
		ticket.setTotalFare(this.totalFare);
		ticket.setNoOfSeats(this.getNoOfSeats());
		return ticket;
	}
	
}
