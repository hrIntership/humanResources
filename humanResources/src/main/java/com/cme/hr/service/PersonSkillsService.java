package com.cme.hr.service;

import java.util.List;




import com.cme.hr.exception.PersonNotFound;
import com.cme.hr.model.Person;
import com.cme.hr.model.PersonSkills;




public interface PersonSkillsService  {
	public List<PersonSkills> findAll();
	public List<PersonSkills> findByidPerson(Integer idPerson);
	public List<PersonSkills> findByidPersonOrderByType(Integer idPerson);
	public PersonSkills create(PersonSkills personSkills);
	public PersonSkills delete(int id) ;
}
