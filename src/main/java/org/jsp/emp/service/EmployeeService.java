package org.jsp.emp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.jsp.emp.dao.EmployeeDao;
import org.jsp.emp.entity.Employee;
import org.jsp.emp.execptionclasses.InvalidCredentialException;
import org.jsp.emp.execptionclasses.InvalidEmployeeIdException;
import org.jsp.emp.execptionclasses.NoActiveEmployeeFoundException;
import org.jsp.emp.util.EmployeeStatus;
import org.jsp.pms.responseStructure.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class EmployeeService {
    @Autowired
	private EmployeeDao dao;
    
	
	public ResponseStructure<Employee> saveEmployee(Employee employee){
		ResponseStructure<Employee> structure=new ResponseStructure<>();
		employee.setStatus(EmployeeStatus.IN_ACTIVE);
		 employee=dao.saveEmployee(employee);
		 structure.setStatus(HttpStatus.CREATED.value());
		 structure.setMessage("Employee saved succesfully");
		 structure.setBody(employee);
		 return structure; 
	}
	public ResponseStructure<Employee> UpdateEmployee(Employee employee){
		ResponseStructure<Employee> structure=new ResponseStructure<>();
		 employee=dao.saveEmployee(employee);
		 structure.setStatus(HttpStatus.OK.value());
		 structure.setMessage("Employee updated succesfully");
		 structure.setBody(employee);
		 return structure; 
	}
	public ResponseStructure<Employee> findEmployeeById(int id){
		ResponseStructure<Employee> structure=new ResponseStructure<>();
		Optional<Employee> op=dao.findEmployeeByid(id);
		if(op.isEmpty()) {
			throw new InvalidEmployeeIdException("Invalid employee id...");
//			structure.setStatus(HttpStatus.NOT_FOUND.value());
//			structure.setMessage("invalid employee id");
//			structure.setBody(null);
		}
		Employee employee=op.get();
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("Employee found successfully");
		structure.setBody(employee);
		return structure;
	}
	
	public ResponseStructure<List<Employee>> findAllEmployee(){
		ResponseStructure<List<Employee>> structure=new ResponseStructure<>();
		List<Employee> li=dao.findAllEmployees();
		if(li.isEmpty()) {
			throw new NoActiveEmployeeFoundException("no active employee");
			}
//		ArrayList<Employee> activeEmployee=new ArrayList<>();
//		for(Employee e:li) {
//			if(e.getStatus()==EmployeeStatus.ACTIVE) {
//				activeEmployee.add(e);
//			}
//			
	//	}
		
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("All Employees found successfully");
		structure.setBody(li);
		return structure;
		
	}
	public ResponseStructure<String> deleteEmployeeById(int id){
		ResponseStructure<String> structure=new ResponseStructure<>();
		Optional<Employee> op=dao.findEmployeeByid(id);
		if(op.isEmpty()) {
			throw new InvalidEmployeeIdException(" invalid employee id unable to delete");
//			structure.setStatus(HttpStatus.BAD_REQUEST.value());
//			structure.setMessage("invalid id");
//			structure.setBody("unable to delete employee");
//			return structure;
		}
		dao.deleteById(id);
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("employee deleted successfully");
		structure.setBody("Employee deleted");
		return structure;
	}
	public ResponseStructure<Employee> findEmployeeByEmailAndPassword(String email,String password){
		ResponseStructure<Employee> structure=new ResponseStructure<>();
		Optional<Employee> op=dao.FindEmployeeByEmailAndPassword(email, password);
		if(op.isEmpty()) {
			throw new InvalidCredentialException("invalid email or password");
//			structure.setStatus(HttpStatus.NOT_FOUND.value());
//			structure.setMessage("invalid credentials");
//			structure.setBody(null);
//			return structure;
			
		}
		Employee em=op.get();
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("verification found successfully");
		structure.setBody(em);
		return structure;
		}
	public ResponseStructure<List<Employee>> findEmployeeByName(String name){
		ResponseStructure<List<Employee>> structure=new ResponseStructure<>();
		List<Employee> li=dao.FindEmployeeByName(name);
		if(li.isEmpty()) {
//			structure.setStatus(HttpStatus.NOT_FOUND.value());
//			structure.setMessage("no employee found");
//			structure.setBody(li);
//			return structure;
		}
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage(" employees found successfully ");
		structure.setBody(li);
		return structure;
	}
	public ResponseStructure<Employee> setEmployeeStatusToActive(int id) {
		ResponseStructure<Employee> structure=new ResponseStructure<>();
		Optional<Employee> op=dao.findEmployeeByid(id);
		if(op.isEmpty()) {
			structure.setStatus(HttpStatus.BAD_REQUEST.value());
			structure.setMessage("invalid employee id");
			structure.setBody(null);
			return structure;
		}
		Employee em=op.get();
		em.setStatus(EmployeeStatus.ACTIVE);
		em=dao.UpdateEmployee(em);
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("employee status updated successfully");
		structure.setBody(em);
		return structure;
		
	}
	public ResponseStructure<Employee> setEmployeeStatusToInActive(int id) {
		ResponseStructure<Employee> structure=new ResponseStructure<>();
		Optional<Employee> op=dao.findEmployeeByid(id);
		if(op.isEmpty()) {
			structure.setStatus(HttpStatus.BAD_REQUEST.value());
			structure.setMessage("invalid employee id...UNABLE TO MAKE IT INACTIVE");
			structure.setBody(null);
			return structure;
		}
		Employee em=op.get();
		em.setStatus(EmployeeStatus.IN_ACTIVE);
		em=dao.UpdateEmployee(em);
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("employee status updated successfully");
		structure.setBody(em);
		return structure;
	}
}
