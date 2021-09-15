package com.infosys.exception;

public class TicketNotFoundException extends Exception
{
	public TicketNotFoundException()
	{
		super();
	}
	public TicketNotFoundException(String message)
	{
		super(message);
	}
}
