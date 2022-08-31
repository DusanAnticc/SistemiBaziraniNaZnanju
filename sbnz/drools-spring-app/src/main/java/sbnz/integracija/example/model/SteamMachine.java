package sbnz.integracija.example.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import sbnz.integracija.example.model.enums.State;

@Entity
public class SteamMachine extends Machine {
    
    private Long currentSteamValue;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "part_id")
    private List<Part> parts;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Valve valve;
    
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private WaterTank waterTank;
    
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Pump pump;
    
    private State state;
    
	public SteamMachine(Long currentSteamValue, List<Part> parts, Valve valve, Pump pump, State state, WaterTank waterTank) {
		super();
		this.currentSteamValue = currentSteamValue;
		this.parts = parts;
		this.valve = valve;
		this.pump = pump;
		this.state = state;
		this.waterTank = waterTank;
	}

	public SteamMachine() {
	}

	public List<Part> getParts() {
		return parts;
	}

	public void setParts(List<Part> parts) {
		this.parts = parts;
	}

	public Valve getValve() {
		return valve;
	}

	public void setValve(Valve valve) {
		this.valve = valve;
	}

	public Pump getPump() {
		return pump;
	}

	public void setPump(Pump pump) {
		this.pump = pump;
	}

	public Long getCurrentSteamValue() {
		return currentSteamValue;
	}

	public void setCurrentSteamValue(Long currentSteamValue) {
		this.currentSteamValue = currentSteamValue;
	}
	
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public WaterTank getWaterTank() {
		return waterTank;
	}

	public void setWaterTank(WaterTank waterTank) {
		this.waterTank = waterTank;
	}
	
	
	
}
