package org.jsp.emp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.emp.entity.Education;
import org.jsp.emp.repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EducationDao {
	@Autowired
	private EducationRepository rep;

	public Education saveEducation(Education e) {
		// TODO Auto-generated method stub
		return rep.save(e);
	}

	public Optional<Education> findEducationByid(int id) {
		// TODO Auto-generated method stub
		return rep.findById(id);
	}

	public List<Education> findAllEducation() {
		// TODO Auto-generated method stub
		return rep.findAll();
	}

	public void deleteById(int id) {
		 rep.deleteById(id);
		
	}

	
}
