
package sbnz.integracija.example.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private User user;
	
	private Date executionTime;
	
	private Date startTime;
	
	private Date endTime;
	
	public Appointment() {
		
	}

	public Appointment(Long id, User user, Date executionTime) {
		super();
		this.id = id;
		this.user = user;
		this.executionTime = executionTime;
	}
	
	

	public Appointment(Long id, User user, Date executionTime, Date startTime) {
		super();
		this.id = id;
		this.user = user;
		this.executionTime = executionTime;
		this.startTime = startTime;
	}

	public Appointment(User user) {
		super();
		this.user = user;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getExecutionTime() {
		return executionTime;
	}

	public void setExecutionTime(Date executionTime) {
		this.executionTime = executionTime;
	}


	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}