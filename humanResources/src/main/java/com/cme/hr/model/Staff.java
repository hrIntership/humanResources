package com.cme.hr.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="staff")
public class Staff {

	@Id
	@GeneratedValue
    private Integer idStaff; 
    

	private Integer idPerson;
	
	private String dateFrom;

	private String dateTo;
	
	private float salary;
	
	private String tasks;
	
	private String workspace;
	
	private String agreement ;
	
	private String category;
	
	private String healthInsurance;
	
	public Integer getIdStaff() {
		return idStaff;
	}

	public void setIdStaff(Integer idStaff) {
		this.idStaff = idStaff;
	}

	public Integer getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(Integer idPerson) {
		this.idPerson = idPerson;
	}

	public String getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}

	public String getDateTo() {
		return dateTo;
	}

	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public String getTasks() {
		return tasks;
	}

	public void setTasks(String tasks) {
		this.tasks = tasks;
	}

	public String getWorkspace() {
		return workspace;
	}

	public void setWorkspace(String workspace) {
		this.workspace = workspace;
	}

	public String getAgreement() {
		return agreement;
	}

	public void setAgreement(String agreement) {
		this.agreement = agreement;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getHealthInsurance() {
		return healthInsurance;
	}

	public void setHealthInsurance(String healthInsurance) {
		this.healthInsurance = healthInsurance;
	}

	
	
}

