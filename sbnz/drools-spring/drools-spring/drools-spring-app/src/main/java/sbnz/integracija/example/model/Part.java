package sbnz.integracija.example.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Part {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    private String name;


    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "log_id")
    private List<Log> logs;


	public Part() {
		
	}

	public Part(Long id, String name, List<Log> logs) {
		super();
		this.id = id;
		this.name = name;
		this.logs = logs;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Log> getLogs() {
		return logs;
	}


	public void setLogs(List<Log> logs) {
		this.logs = logs;
	}
    
    

}
