package com.cme.hr.service;

import java.util.List;

import com.cme.hr.exception.ApplicantNotFound;
import com.cme.hr.model.Applicant;

public interface ApplicantService {
	
	public Applicant create(Applicant applicant);
	public Applicant delete(int id) throws ApplicantNotFound;
	public List<Applicant> findAll();
	public Applicant update(Applicant applicant) throws ApplicantNotFound;
	public Applicant findById(int id);
	public List<Applicant> findByState(String state);

}