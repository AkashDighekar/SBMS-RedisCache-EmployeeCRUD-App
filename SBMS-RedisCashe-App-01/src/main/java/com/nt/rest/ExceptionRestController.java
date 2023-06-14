package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nt.exception.EmployeeNotFoundException;
import com.nt.model.ExceptionInfo;

@RestControllerAdvice
public class ExceptionRestController {
		
	@ExceptionHandler(value = EmployeeNotFoundException.class)
	public ResponseEntity<ExceptionInfo> handaleAe(EmployeeNotFoundException en){
		ExceptionInfo exception = new ExceptionInfo();
		exception.setMsg(en.getMessage());
		exception.setCode("EmpNF-009991");
		return new ResponseEntity<>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
