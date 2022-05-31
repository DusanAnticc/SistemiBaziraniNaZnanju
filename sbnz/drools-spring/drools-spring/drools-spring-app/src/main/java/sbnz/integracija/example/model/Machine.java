package sbnz.integracija.example.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import sbnz.integracija.example.model.enums.State;


@Entity
public abstract class Machine {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
   
	private String brand;
	private String model;
	private String year;
	private State state;
    
}
