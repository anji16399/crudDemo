package com.springboot.crudDemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CloudVendorExceptionHandler {

	@ExceptionHandler(value= {CloudVendorNotFoundException.class})
	public ResponseEntity<Object> handleCloudVendorNotFoundException(CloudVendorNotFoundException cvnfe){
		
		CloudVendorException cvexception = new CloudVendorException(
				cvnfe.getMessage(),cvnfe.getCause(), HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(cvexception, HttpStatus.NOT_FOUND);
	}
}
