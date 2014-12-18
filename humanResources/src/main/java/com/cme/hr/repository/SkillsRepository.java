package com.cme.hr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cme.hr.model.Skills;

public interface SkillsRepository extends JpaRepository<Skills, Integer> {

	List<Skills> findByidTypeSkill(Integer idTypeSkill);
	
}
