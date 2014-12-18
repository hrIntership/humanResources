package com.cme.hr.service;

import java.util.List;

import com.cme.hr.exception.PersonNotFound;
import com.cme.hr.model.Person;
import com.cme.hr.model.Staff;

public interface PersonService {
	
	public Person create(Person person);
	public Person delete(int id) throws PersonNotFound;
	public List<Person> findAll();
	public Person update(Person person) throws PersonNotFound;
	public Person findById(int id);
	public List<Person> findByState(String state);


}
