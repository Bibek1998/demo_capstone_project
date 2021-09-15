package com.infosys.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.infosys.dto.BookedInfoDTO;
import com.infosys.dto.BookedPassengerInfoDTO;
import com.infosys.dto.PassengerDetailsDTO;
import com.infosys.dto.TicketDetailsDTO;
import com.infosys.entity.FlightDetails;
import com.infosys.entity.PassengerDetails;
import com.infosys.entity.TicketDetails;
import com.infosys.exception.TicketNotFoundException;
import com.infosys.repository.FlightDetailsRepository;
import com.infosys.repository.PassengerRepository;
import com.infosys.repository.TicketRepository;

@Service
public class TicketSearchService 
{
	@Autowired
	FlightDetailsRepository flightRepository;
	
	@Autowired
	PassengerRepository passengerRepository;
	
	@Autowired
	TicketRepository ticketRepository;

	public ResponseEntity<BookedInfoDTO> getTickets(String pnr) throws TicketNotFoundException
	{
		Optional<TicketDetails> op = ticketRepository.findById(pnr);
		if(op.isPresent())
		{
			TicketDetails ticketDetails = op.get();
			List<PassengerDetails> passengerDetails = passengerRepository.findByPnr(pnr);
			TicketDetailsDTO dto = ticketDetails.prepareTicketDetailDTO();
			List<BookedPassengerInfoDTO> passengerListDto = new ArrayList<>();
			for(int i = 0; i < passengerDetails.size(); i++)
			{
				BookedPassengerInfoDTO bookedPassengerInfoDto = new BookedPassengerInfoDTO();
				bookedPassengerInfoDto.setPassengerDto(passengerDetails.get(i).preparePassengerDTO());
				bookedPassengerInfoDto.setTicketDto(dto);
				passengerListDto.add(bookedPassengerInfoDto);
			}
			BookedInfoDTO bookedInfoDto = new BookedInfoDTO();
			bookedInfoDto.setPnr(pnr);
			Double total_fare = Double.parseDouble(ticketDetails.getTotalFare());
			bookedInfoDto.setTotalFare(total_fare);
			bookedInfoDto.setPassengerList(passengerListDto);
			return ResponseEntity.ok(bookedInfoDto);
		}
		throw new TicketNotFoundException("Ticket Not Found");
	}
	
}
