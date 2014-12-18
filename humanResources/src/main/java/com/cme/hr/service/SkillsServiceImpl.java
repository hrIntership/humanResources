package com.cme.hr.service;

import java.util.List;

import javax.annotation.Resource;






import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cme.hr.model.Skills;
import com.cme.hr.repository.SkillsRepository;
@Service
public class SkillsServiceImpl implements SkillsService {
	@Resource
	private SkillsRepository skillsRepository;

	@Override
	@Transactional
	public List<Skills> findAll() {
		// TODO Auto-generated method stub
		 return skillsRepository.findAll();
	}

	@Override
	@Transactional
	public List<Skills> findByTypeSkill(int idTypeSkill) {
		// TODO Auto-generated method stub
		return skillsRepository.findByidTypeSkill(idTypeSkill);
	}

	@Override
	@Transactional
	public Skills findById(int id) {
		return skillsRepository.findOne(id);
	}
	

}
