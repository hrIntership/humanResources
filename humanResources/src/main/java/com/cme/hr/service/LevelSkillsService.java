package com.cme.hr.service;

import java.util.List;

import com.cme.hr.model.LevelSkills;


public interface LevelSkillsService {
	public List<LevelSkills> findAll();
	public LevelSkills findById(Integer idLevel);
}
