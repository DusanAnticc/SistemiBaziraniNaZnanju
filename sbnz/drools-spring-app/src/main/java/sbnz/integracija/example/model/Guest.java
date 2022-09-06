package sbnz.integracija.example.model;

import javax.persistence.Entity;

import sbnz.integracija.example.model.enums.ManufactureType;

@Entity
public class Guest extends User {
	
	private Long energyProduced;
	
	private ManufactureType category;
	
	private Long discount; 
	
	private Long owes;
}
