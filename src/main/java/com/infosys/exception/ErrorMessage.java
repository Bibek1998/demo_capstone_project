package com.infosys.exception;

public class ErrorMessage 
{
	private int errorCode;
	private String errorMessages;
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessages;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessages = errorMessage;
	}
	@Override
	public String toString() {
		return "ErrorMessage [errorCode=" + errorCode + ", errorMessage=" + errorMessages + "]";
	}
}
