package org.jsp.emp.execptionclasses;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NoEmployeeFoundException extends RuntimeException {
	private String message;

	public NoEmployeeFoundException(String message) {
		super();
		this.message = message;
	}
	public String getMessage() {
		return this.message;
	}
}
