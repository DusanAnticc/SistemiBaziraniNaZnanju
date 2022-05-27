package sbnz.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "parts")
@NoArgsConstructor @AllArgsConstructor
public class Part {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    private String name;


    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "log_id")
    private List<Log> logs;


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
