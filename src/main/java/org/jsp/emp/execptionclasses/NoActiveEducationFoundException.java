package org.jsp.emp.execptionclasses;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NoActiveEducationFoundException extends RuntimeException {
     private String message;
	
	public NoActiveEducationFoundException(String message) {
		this.message=message;
	}
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}
}
