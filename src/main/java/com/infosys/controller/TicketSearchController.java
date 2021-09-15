package com.infosys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.dto.BookedInfoDTO;
import com.infosys.exception.TicketNotFoundException;
import com.infosys.service.TicketSearchService;

@RestController
@RequestMapping("/viewYourTicket")
public class TicketSearchController 
{
	@Autowired
	TicketSearchService ticketService;
	@PostMapping
	public ResponseEntity<BookedInfoDTO> searchTicket(@RequestParam("pnr") String pnr) throws TicketNotFoundException
	{
		return ticketService.getTickets(pnr);
	}
}
