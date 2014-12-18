package com.cme.hr.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "skills")
public class Skills {
	@Id
	@GeneratedValue
	private Integer idSkill;

	private Integer idTypeSkill;
	
	private String nameSkill;

	public Integer getIdSkill() {
		return idSkill;
	}

	public void setIdSkill(Integer idSkill) {
		this.idSkill = idSkill;
	}

	public Integer getIdTypeSkill() {
		return idTypeSkill;
	}

	public void setIdTypeSkill(Integer idTypeSkill) {
		this.idTypeSkill = idTypeSkill;
	}

	public String getNameSkill() {
		return nameSkill;
	}

	public void setNameSkill(String nameSkill) {
		this.nameSkill = nameSkill;
	}

	

}
