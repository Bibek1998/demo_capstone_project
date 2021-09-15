package com.infosys.dto;

public class TicketDetailsDTO 
{
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

	@Override
	public String toString() {
		return "TicketDetailsDTO [pnr=" + pnr + ", bookingDate=" + bookingDate + ", departureDate=" + departureDate
				+ ", departureTime=" + departureTime + ", totalFare=" + totalFare + ", flightId=" + flightId
				+ ", userId=" + userId + ", noOfSeats=" + noOfSeats + "]";
	}
}
