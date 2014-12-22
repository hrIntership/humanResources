package com.cme.hr.service;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.annotations.OrderBy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;






import com.cme.hr.exception.PersonNotFound;
import com.cme.hr.model.Person;
import com.cme.hr.model.PersonSkills;
import com.cme.hr.repository.PersonSkillsRepository;

@Service
public class PersonSkillsServiceImple implements PersonSkillsService {

	@Resource

	private PersonSkillsRepository personSkillsRepository;

	@Override
	@Transactional
	public List<PersonSkills> findAll() {
		// TODO Auto-generated method stub
		return personSkillsRepository.findAll();
	}

	@Override
	@Transactional
	public List<PersonSkills> findByidPerson(Integer idPerson) {
		// TODO Auto-generated method stub
		return  personSkillsRepository.findByIdPerson(idPerson);
	}

	@Override
	public PersonSkills create(PersonSkills personSkills) {
		PersonSkills createdPersonSkill = personSkills;
		return personSkillsRepository.save(createdPersonSkill);
	
	}

	@Override
	public PersonSkills delete(int id) {
		
		PersonSkills deletedPerson = personSkillsRepository.findOne(id);
		
		personSkillsRepository.delete(deletedPerson);
		return deletedPerson;
	
	}

	@Override
	@Transactional
	public List<PersonSkills> findByidPersonOrderByType(Integer idPerson) {
		// TODO Auto-generated method stub
		return null;
	}
	

}










