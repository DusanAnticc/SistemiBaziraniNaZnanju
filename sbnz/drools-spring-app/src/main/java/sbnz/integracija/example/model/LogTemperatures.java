package sbnz.integracija.example.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class LogTemperatures {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "steam_machine_id") 
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
	

    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (o.getClass() != this.getClass())
            return false;
        LogTemperatures log = (LogTemperatures) o;
        return this.getId().equals(log.getId());
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(this.getId());
    }
}