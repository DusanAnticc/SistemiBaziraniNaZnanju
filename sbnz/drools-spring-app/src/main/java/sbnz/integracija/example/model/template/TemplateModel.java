package sbnz.integracija.example.model.template;


import lombok.Getter;
import lombok.Setter;

public class TemplateModel {
    private Long idMachine;
    private Double upperLimit;
    private Double lowerLimit;
    
    
	public TemplateModel(Long idMachine, Double lowerLimit, Double upperLimit) {
		super();
		this.idMachine = idMachine;
		this.upperLimit = upperLimit;
		this.lowerLimit = lowerLimit;
	}


	public Long getIdMachine() {
		return idMachine;
	}


	public void setIdMachine(Long idMachine) {
		this.idMachine = idMachine;
	}


	public Double getUpperLimit() {
		return upperLimit;
	}


	public void setUpperLimit(Double upperLimit) {
		this.upperLimit = upperLimit;
	}


	public Double getLowerLimit() {
		return lowerLimit;
	}


	public void setLowerLimit(Double lowerLimit) {
		this.lowerLimit = lowerLimit;
	}

	
	

    
}
