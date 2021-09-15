package com.infosys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.entity.PassengerDetails;

public interface PassengerRepository extends JpaRepository<PassengerDetails, Integer>
{
	List<PassengerDetails> findByPnr(String pnr);
}
