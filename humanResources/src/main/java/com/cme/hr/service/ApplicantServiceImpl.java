package com.cme.hr.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cme.hr.exception.ApplicantNotFound;
import com.cme.hr.model.Applicant;
import com.cme.hr.repository.ApplicantRepository;

@Service
public class ApplicantServiceImpl implements ApplicantService {
	
	@Resource
	private ApplicantRepository applicantRepository;

	@Override
	@Transactional
	public Applicant create(Applicant applicant) {
		Applicant createdApplicant = applicant;
		return applicantRepository.save(createdApplicant);
	}
	
	@Override
	@Transactional
	public Applicant findById(int id) {
		return applicantRepository.findOne(id);
	}

	@Override
	@Transactional(rollbackFor=ApplicantNotFound.class)
	public Applicant delete(int id) throws ApplicantNotFound {
		Applicant deletedApplicant = applicantRepository.findOne(id);
		
		if (deletedApplicant == null)
			throw new ApplicantNotFound();
		
		applicantRepository.delete(deletedApplicant);
		return deletedApplicant;
	}

	@Override
	@Transactional
	public List<Applicant> findAll() {
		return applicantRepository.findAll();
	}

	@Override
	@Transactional(rollbackFor=ApplicantNotFound.class)
	public Applicant update(Applicant applicant) throws ApplicantNotFound {
		Applicant updatedApplicant = applicantRepository.findOne(applicant.getIdPerson());
		
		if (updatedApplicant == null)
			throw new ApplicantNotFound();
/*		
		updatedApplicant.setDateFrom(applicant.getDateFrom());
		updatedApplicant.setDateTo(applicant.getDateTo());
		updatedApplicant.setSalary(applicant.getSalary());
		updatedApplicant.setTasks(applicant.getTasks());
		updatedApplicant.setWorkspace(applicant.getWorkspace());
		updatedApplicant.setAgreement(applicant.getAgreement());		
		updatedApplicant.setCategory(applicant.getCategory());
		updatedApplicant.setHealthInsurance(applicant.getHealthInsurance());
*/
		return updatedApplicant;
	}

	@Override
	@Transactional
	public List<Applicant> findByState(String state) {
		return applicantRepository.findByState("internal");

	}

}