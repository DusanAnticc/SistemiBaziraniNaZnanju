package sbnz.integracija.example.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



public class TemplateModelDTO {

	private List<Long> idMachines;
	
	private Double lowerLimit;
	
	private Double upperLimit;
	
	
	

	public TemplateModelDTO() {
		super();
	}

	public TemplateModelDTO(List<Long> idMachines, Double lowerLimit, Double upperLimit) {
		super();
		this.idMachines = idMachines;
		this.lowerLimit = lowerLimit;
		this.upperLimit = upperLimit;
	}

	public List<Long> getIdMachines() {
		return idMachines;
	}

	public void setIdMachines(List<Long> idMachines) {
		this.idMachines = idMachines;
	}

	public Double getLowerLimit() {
		return lowerLimit;
	}

	public void setLowerLimit(Double lowerLimit) {
		this.lowerLimit = lowerLimit;
	}

	public Double getUpperLimit() {
		return upperLimit;
	}

	public void setUpperLimit(Double upperLimit) {
		this.upperLimit = upperLimit;
	}
	
	
	
	
	
	
	
}
