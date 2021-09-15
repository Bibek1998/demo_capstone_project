package com.infosys.exception;

import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.PatternSyntaxException;

import javax.validation.ConstraintViolationException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice 
{
	Log log = LogFactory.getLog(ProjectExceptionAdvice.class);
	@ExceptionHandler(EntityAlreadyExistsException.class)
	public ResponseEntity<ErrorMessage> handleEntityAlreadyExistsException(EntityAlreadyExistsException ex)
	{
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		error.setErrorMessage(ex.getMessage());
		log.error(ex.getMessage());
		return new ResponseEntity<ErrorMessage>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoUserFoundException.class)
	public ResponseEntity<ErrorMessage> handleUserNotFoundException(NoUserFoundException ex)
	{
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		error.setErrorMessage(ex.getMessage());
		log.error(ex.getMessage());
		return new ResponseEntity<ErrorMessage>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CrediCardNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleCreditCardNotFoundException(CrediCardNotFoundException ex)
	{
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		error.setErrorMessage(ex.getMessage());
		log.error(ex.getMessage());
		return new ResponseEntity<ErrorMessage>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BookingUnsuccessfullException.class)
	public ResponseEntity<ErrorMessage> handleBookingUnsuccessfullException(BookingUnsuccessfullException ex)
	{
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		error.setErrorMessage(ex.getMessage());
		log.error(ex.getMessage());
		return new ResponseEntity<ErrorMessage>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(TicketNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleTicketNotFoundException(TicketNotFoundException ex)
	{
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		error.setErrorMessage(ex.getMessage());
		log.error(ex.getMessage());
		return new ResponseEntity<ErrorMessage>(error, HttpStatus.NOT_FOUND);
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValdationException(MethodArgumentNotValidException ex)
	{
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}
	@ExceptionHandler(ConstraintViolationException.class)
    public Map<String, String> handleConstraintValidationExceptions(ConstraintViolationException ex) 
    {
         Map<String, String> errors = new HashMap<>();
         ex.getConstraintViolations().forEach(error ->{
        	 String fieldName = error.getInvalidValue().toString();
        	 String errorMessage = error.getMessage();
        	 errors.put(fieldName, errorMessage);
         });
         return errors;
    }
} 