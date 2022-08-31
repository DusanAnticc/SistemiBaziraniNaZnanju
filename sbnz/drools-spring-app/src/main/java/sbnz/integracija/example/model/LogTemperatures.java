package sbnz.integracija.example.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class LogTemperatures {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private SteamMachine steamMachine;
    
	private Long temperatures;

	public LogTemperatures(Long id, SteamMachine steamMachine, Long temperatures) {
		super();
		this.id = id;
		this.steamMachine = steamMachine;
		this.temperatures = temperatures;
	}
	
	public LogTemperatures() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SteamMachine getSteamMachine() {
		return steamMachine;
	}

	public void setSteamMachine(SteamMachine steamMachine) {
		this.steamMachine = steamMachine;
	}

	public Long getTemperatures() {
		return temperatures;
	}

	public void setTemperatures(Long temperatures) {
		this.temperatures = temperatures;
	}
	
}