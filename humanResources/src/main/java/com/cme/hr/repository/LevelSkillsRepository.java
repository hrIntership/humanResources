package com.cme.hr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cme.hr.model.LevelSkills;


public interface LevelSkillsRepository  extends JpaRepository<LevelSkills, Integer>{

	List<LevelSkills> findByidLevel(Integer idLevel);

}
