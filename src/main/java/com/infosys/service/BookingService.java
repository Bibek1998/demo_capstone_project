package com.infosys.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.infosys.dto.BookedInfoDTO;
import com.infosys.dto.BookedPassengerInfoDTO;
import com.infosys.dto.PassengerDetailsDTO;
import com.infosys.dto.TicketDetailsDTO;
import com.infosys.entity.FlightDetails;
import com.infosys.entity.PassengerDetails;
import com.infosys.entity.TicketDetails;
import com.infosys.exception.BookingUnsuccessfullException;
import com.infosys.repository.FlightDetailsRepository;
import com.infosys.repository.PassengerRepository;
import com.infosys.repository.TicketRepository;

@Service
public class BookingService 
{
	@Autowired
	FlightDetailsRepository flightRepository;
	
	@Autowired
	PassengerRepository passengerRepository;
	
	@Autowired
	TicketRepository ticketRepository;
	Random random = new Random();
	public ResponseEntity<BookedInfoDTO> bookTicket(String flightId, String userId,
	List<PassengerDetailsDTO> passengerList) throws BookingUnsuccessfullException
	{
		Optional<FlightDetails> op = flightRepository.findById(flightId);
		int total_passengers = passengerList.size();
		if(op.isPresent())
		{
			FlightDetails flightDetails = op.get();
			String pnr = "P";
			boolean pnrCheck = false;
			do
			{
				pnr += random.nextInt(999999);
				Optional<TicketDetails> ticketop = ticketRepository.findById(pnr);
				if(ticketop.isPresent())
					pnrCheck = true;
				else
					pnrCheck = false;
			}while(pnrCheck);
			TicketDetails ticket = new TicketDetails();
			prepareTicket(ticket, flightDetails, userId, pnr, total_passengers);
			ticketRepository.save(ticket);
			flightDetails.setSeatCount(flightDetails.getSeatCount()-total_passengers);
			for(int i = 0; i < total_passengers; i++)
			{
				int id;
				boolean passengerIdCheck = false;
				do
				{
					id = random.nextInt(999);
					Optional<PassengerDetails> passengerop = passengerRepository.findById(id);
					if(passengerop.isPresent())
						passengerIdCheck = true;
					else
						passengerIdCheck = false;
				}while(passengerIdCheck);
				passengerList.get(i).setPassengerId(id);
				passengerList.get(i).setPnr(pnr);
				PassengerDetails passengerDetails = passengerList.get(i).preparePassengerEntity();
				passengerRepository.save(passengerDetails);
			}
			List<PassengerDetails> passengerEntitylist = passengerRepository.findByPnr(pnr);
			BookedInfoDTO bookInfoDto = new BookedInfoDTO();
			bookInfoDto.setPnr(pnr);
			bookInfoDto.setTotalFare(total_passengers*flightDetails.getFare());
			for(int i = 0; i < total_passengers; i++)
			{
				BookedPassengerInfoDTO passengerInfoDto = new BookedPassengerInfoDTO();
				PassengerDetailsDTO passengerDetailsDto = passengerEntitylist.get(i).preparePassengerDTO();
				passengerInfoDto.setPassengerDto(passengerDetailsDto);
				TicketDetailsDTO ticketDetailsDto = ticketRepository.getById(pnr).prepareTicketDetailDTO();
				passengerInfoDto.setTicketDto(ticketDetailsDto);
				bookInfoDto.getPassengerList().add(passengerInfoDto);
			}
			return new ResponseEntity<BookedInfoDTO>(bookInfoDto, HttpStatus.ACCEPTED);
		}
		throw new BookingUnsuccessfullException("Ticket Booking Failed");
	}

	private void prepareTicket(TicketDetails ticket, FlightDetails flightDetails, String userId, String pnr, int total_passengers) 
	{
		ticket.setPnr(pnr);
		ticket.setBookingDate(LocalDate.now().toString());
		ticket.setDepartureDate(flightDetails.getFlightAvailableDate().toString());
		ticket.setDepartureTime(flightDetails.getDepartureTime());
		ticket.setTotalFare(Double.toString(total_passengers*flightDetails.getFare()));
		ticket.setFlightId(flightDetails.getFlightId());
		ticket.setUserId(userId);
		ticket.setNoOfSeats(total_passengers);
	}
	
}
