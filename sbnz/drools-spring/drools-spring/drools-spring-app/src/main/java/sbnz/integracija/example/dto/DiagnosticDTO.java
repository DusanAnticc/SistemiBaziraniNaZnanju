package sbnz.integracija.example.dto;

import java.sql.Date;

public class DiagnosticDTO {

	private String fix;
	private Date date;
	
	public DiagnosticDTO() {
		
	}

	public DiagnosticDTO(String fix, Date date) {
		super();
		this.fix = fix;
		this.date = date;
	}

	public String getFix() {
		return fix;
	}

	public void setFix(String fix) {
		this.fix = fix;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}