package sbnz.integracija.example.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class CoalReserves {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    
    private Double maxValue;
    private Double minValue;    
    private Double currentValue;
    
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Furnace furnace;
    
    
	public CoalReserves(Long id, Double maxValue, Double minValue, Double currentValue, Furnace furnace,
			Valve inputValve, Valve outputValve) {
		super();
		this.id = id;
		this.maxValue = maxValue;
		this.minValue = minValue;
		this.currentValue = currentValue;
		this.furnace = furnace;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(Double maxValue) {
		this.maxValue = maxValue;
	}

	public Double getMinValue() {
		return minValue;
	}

	public void setMinValue(Double minValue) {
		this.minValue = minValue;
	}

	public Double getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(Double currentValue) {
		this.currentValue = currentValue;
	}

	public Furnace getFurnace() {
		return furnace;
	}

	public void setFurnace(Furnace furnace) {
		this.furnace = furnace;
	}

	

}
