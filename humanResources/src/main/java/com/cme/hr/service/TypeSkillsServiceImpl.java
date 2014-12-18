package com.cme.hr.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cme.hr.model.TypeSkills;
import com.cme.hr.repository.TypeSkillsRepository;
@Service
public class TypeSkillsServiceImpl implements TypeSkillsService{
	@Resource
	private TypeSkillsRepository typeSkillsRepository;
	
	@Override
	@Transactional
	public List<TypeSkills> findAll() {
		// TODO Auto-generated method stub
		return typeSkillsRepository.findAll();
	}

	@Override
	@Transactional
	public TypeSkills findById(Integer idTypeSkill) {
		// TODO Auto-generated method stub
		return typeSkillsRepository.findOne(idTypeSkill);
	}



}
