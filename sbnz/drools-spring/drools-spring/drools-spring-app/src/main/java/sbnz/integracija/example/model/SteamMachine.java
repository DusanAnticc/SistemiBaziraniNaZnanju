package sbnz.integracija.example.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class SteamMachine extends Machine {
    
    private Long currentSteamValue;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "part_id")
    private List<Part> parts;

    @OneToOne(fetch = FetchType.EAGER)
    private Valve valve;
    
    @OneToOne(fetch = FetchType.EAGER)
    private Pump pump;
    
	public SteamMachine(Long currentSteamValue, List<Part> parts, Valve valve, Pump pump) {
		super();
		this.currentSteamValue = currentSteamValue;
		this.parts = parts;
		this.valve = valve;
		this.pump = pump;
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
	
	
}
