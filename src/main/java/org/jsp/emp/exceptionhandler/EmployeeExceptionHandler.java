package org.jsp.emp.exceptionhandler;

import java.sql.SQLIntegrityConstraintViolationException;


import org.jsp.emp.execptionclasses.InvalidCredentialException;
import org.jsp.emp.execptionclasses.NoActiveEmployeeFoundException;
import org.jsp.emp.execptionclasses.NoEmployeeFoundException;
import org.jsp.pms.responseStructure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeeExceptionHandler {
  @ExceptionHandler(NoActiveEmployeeFoundException.class)
  public ResponseEntity noActiveEmployeeFoundExceptionHandler(NoActiveEmployeeFoundException e) {
	  ResponseStructure<String> structure=new ResponseStructure<>();
	  structure.setStatus(HttpStatus.NOT_FOUND.value());
	  structure.setMessage("no active employee found");
	  structure.setBody(e.getMessage());
	  
	return new ResponseEntity(structure,HttpStatus.BAD_REQUEST);
  }
  @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
  public ResponseEntity sQLIntegrityViolationExceptionHandler(SQLIntegrityConstraintViolationException e) {
	  ResponseStructure<String> structure=new ResponseStructure<>();
	  structure.setStatus(HttpStatus.BAD_REQUEST.value());
	  structure.setMessage("Invalid email or phone ");
	  structure.setBody(e.getMessage());
	  
	return new ResponseEntity(structure,HttpStatus.BAD_REQUEST);
  }
  @ExceptionHandler(InvalidCredentialException.class)
  public ResponseEntity invalidCredentialException(InvalidCredentialException e) {
	  ResponseStructure<String> structure=new ResponseStructure<>();
	  structure.setStatus(HttpStatus.BAD_REQUEST.value());
	  structure.setMessage("Invalid credentails ");
	  structure.setBody(e.getMessage());
	  
	return new ResponseEntity(structure,HttpStatus.BAD_REQUEST);
  }
  @ExceptionHandler(NoEmployeeFoundException.class)
  public ResponseEntity noEmployeeFoundException(NoEmployeeFoundException e) {
	  ResponseStructure<String> structure=new ResponseStructure<>();
	  structure.setStatus(HttpStatus.BAD_REQUEST.value());
	  structure.setMessage("Invalid credentails ");
	  structure.setBody(e.getMessage());
	  
	return new ResponseEntity(structure,HttpStatus.BAD_REQUEST);
  }
  
}
