package com.cme.hr.service;

import java.util.List;

import com.cme.hr.model.Skills;



public interface SkillsService {
	
	public List<Skills> findAll();
	public List<Skills> findByTypeSkill(int idTypeSkill);
	public Skills findById(int idSkill);

}
