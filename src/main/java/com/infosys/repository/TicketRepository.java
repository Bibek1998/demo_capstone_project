package com.infosys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.entity.TicketDetails;

public interface TicketRepository extends JpaRepository<TicketDetails, String>
{
	
}
