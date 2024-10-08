package org.jsp.emp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.emp.entity.Employee;
import org.jsp.emp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDao {
   @Autowired
	private EmployeeRepository rep;
	
   
   public Employee saveEmployee(Employee emp) {
	   return rep.save(emp);
   }
   
   public Employee UpdateEmployee(Employee emp) {
	   return rep.save(emp);
   }
   
   public Optional<Employee> findEmployeeByid(int id){
	   return rep.findById(id);
   }
   
   public List<Employee> findAllEmployees(){
	   return rep.findAll();
   }
   public List<Employee> findAllActiveEmployees(){
	   return rep.findAllActiveEmployees();
   }
   
   public void deleteById(int id) {
	  rep.deleteById(id);
   }
   
   public Optional<Employee> FindEmployeeByEmailAndPassword(String email,String password){
	   return rep.findByEmailAndPassword(email,password);
   }
   
   public List<Employee> FindEmployeeByName(String name){
	return rep.findByName(name);
	   
   }

}
