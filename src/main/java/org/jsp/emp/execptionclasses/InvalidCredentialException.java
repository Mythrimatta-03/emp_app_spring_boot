package org.jsp.emp.execptionclasses;

public class InvalidCredentialException extends RuntimeException {
	private String message;

	public InvalidCredentialException(String message) {
		super();
		this.message = message;
	}
	public String getMessage() {
		return this.message;
	}

}
