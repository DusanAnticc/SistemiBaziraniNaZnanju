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
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
	private String message;
	private String userName;
	private Long executionTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "part_id")
    private Part part;
    
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private SteamMachine steamMachine;

	public Log() {
		
	}

	public Log(Long id, String message, String userName, Long executionTime, Part part, SteamMachine steamMachine) {
		super();
		this.id = id;
		this.message = message;
		this.userName = userName;
		this.executionTime = executionTime;
		this.part = part;
		this.steamMachine = steamMachine;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getExecutionTime() {
		return executionTime;
	}

	public void setExecutionTime(Long executionTime) {
		this.executionTime = executionTime;
	}

	public Part getPart() {
		return part;
	}

	public void setPart(Part part) {
		this.part = part;
	}

	public SteamMachine getSteamMachine() {
		return steamMachine;
	}

	public void setSteamMachine(SteamMachine steamMachine) {
		this.steamMachine = steamMachine;
	}
    
	
    
}
