package com.cme.hr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



import com.cme.hr.model.TypeSkills;



public interface TypeSkillsRepository extends JpaRepository<TypeSkills, Integer>{

	List<TypeSkills> findByIdTypeSkill(Integer idTypeSkill);

}
