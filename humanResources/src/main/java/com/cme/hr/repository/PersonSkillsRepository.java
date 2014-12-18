package com.cme.hr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.cme.hr.model.PersonSkills;




public interface PersonSkillsRepository extends JpaRepository<PersonSkills, Integer> {
	
	List<PersonSkills> findByIdPerson(Integer idPerson);
	
}
