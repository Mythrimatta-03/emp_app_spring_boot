package org.jsp.emp.execptionclasses;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InvalidEducationIdException extends RuntimeException{
	private String message;

	public InvalidEducationIdException(String message) {
		super();
		this.message = message;
	}
	public String getMessage() {
		return this.message;
	}
}
