package org.jsp.emp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
@Data

@Entity
public class Education 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
  private int id;
  private String qualification;
  private String universityname;
  private double percentage;
  private int completionYear;
  private String HighestQualification;
  @ManyToOne
  private Employee employee;
}
