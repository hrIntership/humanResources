package com.cme.hr.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "typeskill")
public class TypeSkills {
	@Id
	@GeneratedValue
	private Integer idTypeSkill;
	
	private String nameType;

	public Integer getIdTypeSkill() {
		return idTypeSkill;
	}

	public void setIdTypeSkill(Integer idTypeSkill) {
		this.idTypeSkill = idTypeSkill;
	}

	public String getNameType() {
		return nameType;
	}

	public void setNameType(String nameType) {
		this.nameType = nameType;
	}
	
}
