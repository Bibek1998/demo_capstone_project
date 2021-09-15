package com.infosys.exception;

public class EntityAlreadyExistsException extends Exception
{
	public EntityAlreadyExistsException()
	{
		super();
	}
	public EntityAlreadyExistsException(String message)
	{
		super(message);
	}
}
