package com.cme.hr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cme.hr.model.Person;
import com.cme.hr.model.Staff;

public interface PersonRepository extends JpaRepository<Person, Integer> {

	List<Person> findByState(String state);

}