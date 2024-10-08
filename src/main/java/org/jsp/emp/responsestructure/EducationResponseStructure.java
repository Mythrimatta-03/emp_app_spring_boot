package org.jsp.emp.responsestructure;

import lombok.Data;

@Data
public class EducationResponseStructure<T> {
	private int status;
	 private String message;
	 private T body;
	 
}
