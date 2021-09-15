package com.infosys.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.dto.CreditCardDetailsDTO;
import com.infosys.dto.UserDetailsDTO;
import com.infosys.exception.CrediCardNotFoundException;
import com.infosys.exception.Message;
import com.infosys.service.CreditCardService;

@RestController
@RequestMapping("/creditCardValidation")
public class CreditCardCheckController 
{
	@Autowired
	CreditCardService creditCardService;
	
	@GetMapping
	public ResponseEntity<Message> checkLogin(@Valid @RequestBody CreditCardDetailsDTO dto) throws CrediCardNotFoundException
	{
		return creditCardService.checkCreditCardValidity(dto);
	}	
}
