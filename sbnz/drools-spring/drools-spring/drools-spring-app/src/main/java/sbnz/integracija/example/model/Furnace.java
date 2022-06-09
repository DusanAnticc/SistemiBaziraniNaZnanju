package sbnz.integracija.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Furnace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    
    private Double Temperatures;


	public Furnace(Long id, Double temperatures) {
		super();
		this.id = id;
		Temperatures = temperatures;
	}
    
	public Furnace() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getTemperatures() {
		return Temperatures;
	}

	public void setTemperatures(Double temperatures) {
		Temperatures = temperatures;
	}

	

}
