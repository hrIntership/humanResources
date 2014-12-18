package com.cme.hr.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "emergencycontact")
public class EmergencyContacts implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer idEC;
 
	private Integer idPerson;

	private String fullName;

	private String relationship;

	private String movile;

	public Integer getIdEC() {
		return idEC;
	}

	public void setIdEC(Integer idEC) {
		this.idEC = idEC;
	}
	
	public Integer getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(Integer idPerson) {
		this.idPerson = idPerson;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getMovile() {
		return movile;
	}

	public void setMovile(String movile) {
		this.movile = movile;
	}
	
	
}
