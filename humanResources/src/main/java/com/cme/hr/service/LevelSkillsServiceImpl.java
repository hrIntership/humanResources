package com.cme.hr.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cme.hr.model.LevelSkills;
import com.cme.hr.repository.LevelSkillsRepository;


@Service
public class LevelSkillsServiceImpl implements LevelSkillsService{
	@Resource
	private LevelSkillsRepository levelSkillsRepository;
	
	@Override
	@Transactional
	public List<LevelSkills> findAll() {
		// TODO Auto-generated method stub
		return levelSkillsRepository.findAll();
	}

	@Override
	@Transactional
	public LevelSkills findById(Integer idLevel) {
		// TODO Auto-generated method stub
		return levelSkillsRepository.findOne(idLevel);
	}

	



}
