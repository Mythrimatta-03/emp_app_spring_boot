package org.jsp.emp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.emp.dao.EducationDao;

import org.jsp.emp.entity.Education;
import org.jsp.emp.execptionclasses.InvalidEducationIdException;
import org.jsp.emp.execptionclasses.NoActiveEducationFoundException;
import org.jsp.emp.util.EmployeeStatus;
import org.jsp.pms.responseStructure.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

public class EducationService {
	@Autowired(required=true)
	private EducationDao dao;
    
	
	public ResponseStructure<Education> saveEducation(Education e){
		ResponseStructure<Education> structure=new ResponseStructure<>();
		  e=dao.saveEducation(e);
		 structure.setStatus(HttpStatus.CREATED.value());
		 structure.setMessage("Employee saved succesfully");
		 structure.setBody(e);
		 return structure; 
	}
	public ResponseStructure<Education> UpdateEducation(Education e){
		ResponseStructure<Education> structure=new ResponseStructure<>();
		 e=dao.saveEducation(e);
		 structure.setStatus(HttpStatus.OK.value());
		 structure.setMessage("Education updated succesfully");
		 structure.setBody(e);
		 return structure; 
	}
	public ResponseStructure<Education> findEducationById(int id){
		ResponseStructure<Education> structure=new ResponseStructure<>();
		Optional<Education> op=dao.findEducationByid(id);
		if(op.isEmpty()) {
			throw new InvalidEducationIdException("Invalid education id...");
//			structure.setStatus(HttpStatus.NOT_FOUND.value());
//			structure.setMessage("invalid employee id");
//			structure.setBody(null);
		}
		Education e=op.get();
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("Education found successfully");
		structure.setBody(e);
		return structure;
	}
	
	public ResponseStructure<List<Education>> findAllEducation(){
		ResponseStructure<List<Education>> structure=new ResponseStructure<>();
		List<Education> li=dao.findAllEducation();
		if(li.isEmpty()) {
			throw new NoActiveEducationFoundException("no education found");
			}
//		ArrayList<Employee> activeEmployee=new ArrayList<>();
//		for(Employee e:li) {
//			if(e.getStatus()==EmployeeStatus.ACTIVE) {
//				activeEmployee.add(e);
//			}
//			
	//	}
		
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("All Educations found successfully");
		structure.setBody(li);
		return structure;
		
	}
	public ResponseStructure<String> deleteEducationById(int id){
		ResponseStructure<String> structure=new ResponseStructure<>();
		Optional<Education> op=dao.findEducationByid(id);
		if(op.isEmpty()) {
			throw new InvalidEducationIdException(" invalid education id unable to delete");
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
	

}
