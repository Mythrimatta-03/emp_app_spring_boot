package org.jsp.emp.exceptionhandler;

import org.jsp.emp.execptionclasses.InvalidEducationIdException;
import org.jsp.emp.execptionclasses.NoActiveEducationFoundException;
import org.jsp.pms.responseStructure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EducationExceptionHandler {
	@ExceptionHandler(NoActiveEducationFoundException.class)
	  public ResponseEntity noActiveEducationFoundExceptionHandler(NoActiveEducationFoundException e) {
		  ResponseStructure<String> structure=new ResponseStructure<>();
		  structure.setStatus(HttpStatus.NOT_FOUND.value());
		  structure.setMessage("no active education found");
		  structure.setBody(e.getMessage());
		  
		return new ResponseEntity(structure,HttpStatus.BAD_REQUEST);
	  }
	  @ExceptionHandler(InvalidEducationIdException.class)
	  public ResponseEntity invalidEducationIdException(InvalidEducationIdException e) {
		  ResponseStructure<String> structure=new ResponseStructure<>();
		  structure.setStatus(HttpStatus.BAD_REQUEST.value());
		  structure.setMessage("Invalid credentails ");
		  structure.setBody(e.getMessage());
		  
		return new ResponseEntity(structure,HttpStatus.BAD_REQUEST);
	  }
	
}
