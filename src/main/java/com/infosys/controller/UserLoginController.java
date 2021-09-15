package com.infosys.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.dto.FlightDetailsDTO;
import com.infosys.dto.UserDetailsDTO;
import com.infosys.exception.ErrorMessage;
import com.infosys.exception.Message;
import com.infosys.exception.NoUserFoundException;
import com.infosys.service.FlightService;
import com.infosys.service.UserService;

@RestController
@RequestMapping("/login")
public class UserLoginController 
{
	@Autowired
	UserService userService;
	
	@GetMapping
	public ResponseEntity<Message> checkLogin(@Valid @RequestBody UserDetailsDTO dto) throws NoUserFoundException
	{
		return userService.checkLoginCredentials(dto);
	}	
	
}
