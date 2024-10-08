package org.jsp.emp.execptionclasses;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NoActiveEmployeeFoundException extends RuntimeException {
	private String message;
	
	public NoActiveEmployeeFoundException(String message) {
		this.message=message;
	}
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}
	

}
