package utils;


import org.springframework.stereotype.Component;


@Component
public class UtilsContainer {


	private String stringType;
	private String stringSkill;
	private String stringLevel;
    private Integer id;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UtilsContainer(String stringOne, String stringtwo, String stringthree ,Integer id) {
	    this.id=id;
		this.stringType = stringOne;
		this.stringSkill = stringtwo;
		this.stringLevel = stringthree;
	}

	public String getStringType() {
		return stringType;
	}

	public void setStringType(String stringType) {
		this.stringType = stringType;
	}

	public String getStringSkill() {
		return stringSkill;
	}

	public void setStringSkill(String stringSkill) {
		this.stringSkill = stringSkill;
	}

	public String getStringLevel() {
		return stringLevel;
	}

	public void setStringLevel(String stringLevel) {
		this.stringLevel = stringLevel;
	}
     
	
	
}
