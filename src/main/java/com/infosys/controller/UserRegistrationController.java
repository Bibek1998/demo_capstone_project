package com.infosys.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.dto.UserDetailsDTO;
import com.infosys.exception.EntityAlreadyExistsException;
import com.infosys.exception.Message;
import com.infosys.service.UserService;

@RestController
@RequestMapping("/registration")
public class UserRegistrationController 
{
	@Autowired
	UserService userService;
	
	@PostMapping
	public ResponseEntity<Message> userRegistration(@Valid @RequestBody UserDetailsDTO dto) throws EntityAlreadyExistsException
	{
		return userService.userRegistration(dto);
	}
	
}
