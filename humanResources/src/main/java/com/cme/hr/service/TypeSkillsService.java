package com.cme.hr.service;

import java.util.List;


import com.cme.hr.model.TypeSkills;

public interface TypeSkillsService {
	public List<TypeSkills> findAll();
	public TypeSkills findById(Integer idTypeSkill);
	
	

}
