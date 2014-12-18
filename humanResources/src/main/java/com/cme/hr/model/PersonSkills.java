package com.cme.hr.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "personskill")
public class PersonSkills {
	@Id
	@GeneratedValue
	private Integer idPersonSkill;
	
	private Integer idPerson;
	
	private Integer idSkill;
	
	private Integer idLevel;

	public Integer getIdPersonSkill() {
		return idPersonSkill;
	}

	public void setIdPersonSkill(Integer idPersonSkill) {
		this.idPersonSkill = idPersonSkill;
	}

	public Integer getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(Integer idPerson) {
		this.idPerson = idPerson;
	}

	public Integer getIdSkill() {
		return idSkill;
	}

	public void setIdSkill(Integer idSkill) {
		this.idSkill = idSkill;
	}

	public Integer getIdLevel() {
		return idLevel;
	}

	public void setIdLevel(Integer idLevel) {
		this.idLevel = idLevel;
	}
}
