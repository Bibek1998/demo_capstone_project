package com.infosys.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.infosys.dto.CreditCardDetailsDTO;
import com.infosys.entity.CreditCardDetails;
import com.infosys.exception.CrediCardNotFoundException;
import com.infosys.exception.Message;
import com.infosys.repository.CreditCardRepository;

@Service
public class CreditCardService 
{
	@Autowired
	CreditCardRepository creditCardRepository;
	
	public ResponseEntity<Message> checkCreditCardValidity(CreditCardDetailsDTO dto) throws CrediCardNotFoundException
	{
		Optional<CreditCardDetails> op = creditCardRepository.findByCardNumberAndCvvAndSecurepin(dto.getCardNumber(), dto.getCvv(), dto.getSecurepin());
		if(op.isPresent())
		{
			CreditCardDetails detail = op.get();
			if(detail.getCardHolderName().equals(dto.getCardHolderName()) &&
			detail.getExpiryMonth().equals(dto.getExpiryMonth()) && 
			detail.getExpiryYear().equals(dto.getExpiryYear()))
			{
				Message message = new Message();
				message.setMessageCode(HttpStatus.ACCEPTED.value());
				message.setMessage("Credit Card Details Validated");
				return ResponseEntity.ok(message);
			}
			else
				throw new CrediCardNotFoundException("Credit Card is Not Valid");
		}
		throw new CrediCardNotFoundException("Credit Card Not Found");
	}
}
