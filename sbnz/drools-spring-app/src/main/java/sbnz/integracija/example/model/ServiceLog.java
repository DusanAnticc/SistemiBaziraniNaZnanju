package sbnz.integracija.example.model;

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

import sbnz.integracija.example.model.Part;
import sbnz.integracija.example.model.SteamMachine;

@Entity
public class ServiceLog {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

	private Long executionTime;
    
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    private SteamMachine steamMachine;
    
    public ServiceLog() {
	}

	public ServiceLog(Long id, Long executionTime, SteamMachine steamMachine) {
		super();
		this.id = id;
		this.executionTime = executionTime;
		this.steamMachine = steamMachine;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getExecutionTime() {
		return executionTime;
	}

	public void setExecutionTime(Long executionTime) {
		this.executionTime = executionTime;
	}

	public SteamMachine getSteamMachine() {
		return steamMachine;
	}

	public void setSteamMachine(SteamMachine steamMachine) {
		this.steamMachine = steamMachine;
	}

	    
}
