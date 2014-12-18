package com.cme.hr.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="applicant")
@PrimaryKeyJoinColumn(name="idPerson")
public class Applicant extends Person{

}

