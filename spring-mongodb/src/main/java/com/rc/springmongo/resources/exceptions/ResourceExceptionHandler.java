package com.rc.springmongo.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.rc.springmongo.services.exception.ObjectNotFundException;

//essa classe é responsavel, por tratar possiveis erros nas requisicoes
@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFundException.class)
	public ResponseEntity<StandarError> objectNotFound(ObjectNotFundException e,
			HttpServletRequest request){
		
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandarError err = new StandarError(System.currentTimeMillis(),
				status.value(), "Não encontrado", e.getMessage(), request.getRequestURI()
				);
		return ResponseEntity.status(status).body(err);
	}

}
