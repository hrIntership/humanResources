package com.cme.hr.service;

import java.util.List;

import com.cme.hr.exception.StaffNotFound;
import com.cme.hr.model.Person;
import com.cme.hr.model.Staff;

public interface StaffService {
	
	public Staff create(Staff staff);
	public Staff delete(int id) throws StaffNotFound;
	public List<Staff> findAll();
	public Staff update(Staff staff) throws StaffNotFound;
	public Staff findById(int id);

}