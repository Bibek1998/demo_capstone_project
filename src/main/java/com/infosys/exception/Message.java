package com.infosys.exception;

public class Message 
{
	private int messageCode;
	private String messages;
	public int getMessageCode() {
		return messageCode;
	}
	public void setMessageCode(int messageCode) {
		this.messageCode = messageCode;
	}
	public String getMessage() {
		return messages;
	}
	public void setMessage(String message) {
		this.messages = message;
	}
	@Override
	public String toString() {
		return "Message [messageCode=" + messageCode + ", message=" + messages + "]";
	}
	
}
