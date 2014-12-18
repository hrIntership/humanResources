package com.cme.hr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cme.hr.model.Applicant;

public interface ApplicantRepository extends JpaRepository<Applicant, Integer> {

	List<Applicant> findByIdPerson(Integer idPerson);

	List<Applicant> findByState(String state);

}