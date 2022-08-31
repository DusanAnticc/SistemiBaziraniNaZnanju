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
public class WaterTank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    
    private Double maxValue;
    private Double minValue;    
    private Double currentValue;

	private Double mineralsInWater;
	
	private Boolean enoughMinerals;
    
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Valve inputValve;
    
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Valve outputValve;
    
	public WaterTank(Long id, Double maxValue, Double minValue, Double currentValue, Double mineralsInWater,
			Valve inputValve, Valve outputValve, Boolean enoughMinerals) {
		super();
		this.id = id;
		this.maxValue = maxValue;
		this.minValue = minValue;
		this.currentValue = currentValue;
		this.mineralsInWater = mineralsInWater;
		this.inputValve = inputValve;
		this.outputValve = outputValve;
		this.enoughMinerals = enoughMinerals;
	}

	public WaterTank() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getMaxValue() {
		return this.maxValue;
	}

	public void setMaxValue(Double maxValue) {
		this.maxValue = maxValue;
	}

	public Double getMinValue() {
		return this.minValue;
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

	public Double getMineralsInWater() {
		return mineralsInWater;
	}

	public void setMineralsInWater(Double mineralsInWater) {
		this.mineralsInWater = mineralsInWater;
	}
    
	 public Valve getInputValve() {
			return inputValve;
	}

	public void setInputValve(Valve inputValve) {
		this.inputValve = inputValve;
	}

	public Valve getOutputValve() {
		return outputValve;
	}

	public void setOutputValve(Valve outputValve) {
		this.outputValve = outputValve;
	}

	public Boolean getEnoughMinerals() {
		return enoughMinerals;
	}

	public void setEnoughMinerals(Boolean enoughMinerals) {
		this.enoughMinerals = enoughMinerals;
	}
	
	
	
}
