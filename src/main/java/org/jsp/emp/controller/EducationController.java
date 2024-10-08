package org.jsp.emp.controller;

import java.util.List;

import org.jsp.emp.entity.Education;
import org.jsp.emp.service.EducationService;
import org.jsp.pms.responseStructure.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/educations")
public class EducationController {
	 @Autowired
		private EducationService service;
	    
	    @PostMapping
	    public ResponseStructure<Education> saveEducation(@RequestBody Education e){
	    	return service.saveEducation(e);
	    	
	    }
	    @PutMapping
	    public ResponseStructure<Education> UpdateEducation(@RequestBody Education e){
	    	return service.UpdateEducation(e);
	    	
	    }
	    @GetMapping
	    public ResponseStructure<List<Education>> findAllEducation(){
	    	return service.findAllEducation();
	    	
	    }
	    @GetMapping("/{id}")
	    public ResponseStructure<Education> findEducationById(@PathVariable int id){
	    	return service.findEducationById(id);
	    	
	    }
}
