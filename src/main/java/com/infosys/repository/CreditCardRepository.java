package com.infosys.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.entity.CreditCardDetails;

public interface CreditCardRepository extends JpaRepository<CreditCardDetails, String>
{
	Optional<CreditCardDetails> findByCardNumberAndCvvAndSecurepin(String cardNumber, String cvv, String securePin);
}
