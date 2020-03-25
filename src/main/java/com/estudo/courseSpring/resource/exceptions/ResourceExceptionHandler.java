package com.estudo.courseSpring.resource.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.estudo.courseSpring.service.exceptions.DatabaseException;
import com.estudo.courseSpring.service.exceptions.ResourceNotFoundException;


//Intercepta as exceções para que este obj possar executar um possivel tratamento.
@ControllerAdvice
public class ResourceExceptionHandler{
	
	
	//Esta annotation vai intercepta qualquer exceção do tipo ResourceNotFoundException.class e
	//Faz o tratamento
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e,
			HttpServletRequest resquest){
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err 
		= new StandardError(Instant.now(), status.value(), error, e.getMessage(), resquest.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandardError> database(DatabaseException e, 
			HttpServletRequest resquest){
		String error = "Database error";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err
		= new StandardError(Instant.now(), status.value(), error, e.getMessage(), resquest.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
}
