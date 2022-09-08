package sbnz.integracija.example.model;

import javax.persistence.Entity;

import sbnz.integracija.example.model.enums.ManufactureType;

@Entity
public class Guest extends User {
	
	private Long energyProduced;
	
	private ManufactureType category;
	
	private Long discount; 
	
	private Long owes;

	public Long getEnergyProduced() {
		return energyProduced;
	}

	public void setEnergyProduced(Long energyProduced) {
		this.energyProduced = energyProduced;
	}

	public ManufactureType getCategory() {
		return category;
	}

	public void setCategory(ManufactureType category) {
		this.category = category;
	}

	public Long getDiscount() {
		return discount;
	}

	public void setDiscount(Long discount) {
		this.discount = discount;
	}
	

	public Long getOwes() {
		return owes;
	}

	public void setOwes(Long owes) {
		this.owes = owes;
	}

}
