package com.infosys.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.infosys.dto.UserDetailsDTO;
import com.infosys.entity.UserDetails;
import com.infosys.exception.EntityAlreadyExistsException;
import com.infosys.exception.ErrorMessage;
import com.infosys.exception.Message;
import com.infosys.exception.NoUserFoundException;
import com.infosys.repository.UserRepository;

@Service
@Transactional
public class UserService 
{
	@Autowired
	UserRepository userRepository;
	
	Log log = LogFactory.getLog(UserService.class);
	public ResponseEntity<Message> checkLoginCredentials(UserDetailsDTO dto) throws NoUserFoundException
	{
		Optional<UserDetails> op = userRepository.findByUserIdAndPassword(dto.getUserId(), dto.getPassword());
		if(op.isPresent())
		{
			Message message = new Message();
			message.setMessageCode(HttpStatus.ACCEPTED.value());
			message.setMessage("Login Successful");
			return ResponseEntity.ok(message);
		}
		throw new NoUserFoundException("User Not Found");
	}
	
	public ResponseEntity<Message> userRegistration(UserDetailsDTO dto) throws EntityAlreadyExistsException
	{
		UserDetails user = dto.prepareUserEntity();
		Optional<UserDetails> op = userRepository.findById(user.getUserId());
		if(op.isPresent())
			throw new EntityAlreadyExistsException("User Already Exists");
		userRepository.save(user);
		log.info("User Has Added");
		Message message = new Message();
		message.setMessageCode(HttpStatus.ACCEPTED.value());
		message.setMessage("Registration Successful");
		return ResponseEntity.ok(message);
	}
}
