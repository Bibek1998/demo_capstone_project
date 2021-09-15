package com.infosys.dto;

public class BookedPassengerInfoDTO 
{
	private PassengerDetailsDTO passengerDto;
	private TicketDetailsDTO ticketDto;
	
	public BookedPassengerInfoDTO() {}

	public BookedPassengerInfoDTO(PassengerDetailsDTO passengerDto, TicketDetailsDTO ticketDto) {
		super();
		this.passengerDto = passengerDto;
		this.ticketDto = ticketDto;
	}

	public PassengerDetailsDTO getPassengerDto() {
		return passengerDto;
	}

	public void setPassengerDto(PassengerDetailsDTO passengerDto) {
		this.passengerDto = passengerDto;
	}

	public TicketDetailsDTO getTicketDto() {
		return ticketDto;
	}

	public void setTicketDto(TicketDetailsDTO ticketDto) {
		this.ticketDto = ticketDto;
	}

	@Override
	public String toString() {
		return "BookedPassengerInfoDTO [passengerDto=" + passengerDto + ", ticketDto=" + ticketDto + "]";
	}
}
