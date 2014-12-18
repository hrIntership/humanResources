package com.cme.hr.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "supplementaryinfo")
public class SupplementaryInfo implements Serializable {

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue
		private Integer idSI;
		
		private Integer idPerson;
		
		private String operation;
		
		private Integer opAmount;
		
		private String opCauses;
		
		private String allergy;
		
		private String preexDiseases;
		
		private String bloodType;

		public Integer getIdSI() {
			return idSI;
		}

		public void setIdSI(Integer idSI) {
			this.idSI = idSI;
		}	

		public Integer getIdPerson() {
			return idPerson;
		}

		public void setIdPerson(Integer idPerson) {
			this.idPerson = idPerson;
		}

		public String getOperation() {
			return operation;
		}

		public void setOperation(String operation) {
			this.operation = operation;
		}

		public Integer getOpAmount() {
			return opAmount;
		}

		public void setOpAmount(Integer opAmount) {
			this.opAmount = opAmount;
		}

		public String getOpCauses() {
			return opCauses;
		}

		public void setOpCauses(String opCauses) {
			this.opCauses = opCauses;
		}

		public String getAllergy() {
			return allergy;
		}

		public void setAllergy(String allergy) {
			this.allergy = allergy;
		}

		public String getPreexDiseases() {
			return preexDiseases;
		}

		public void setPreexDiseases(String preexDiseases) {
			this.preexDiseases = preexDiseases;
		}

		public String getBloodType() {
			return bloodType;
		}

		public void setBloodType(String bloodType) {
			this.bloodType = bloodType;
		}



}
