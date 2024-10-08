package org.jsp.emp.execptionclasses;

public class InvalidEmployeeIdException extends RuntimeException {
   
	
	private String message;

	public InvalidEmployeeIdException(String message) {
		super();
		this.message = message;
	}
	public String getMessage() {
		return this.message;
	}
}
