package org.jsp.emp.responsestructure;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeResponseStructure<T> {
 private int status;
 private String message;
 private T body;
 
}
