package sbnz.integracija.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Valve {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    
    private Boolean isOpen;


	public Valve(Long id, Boolean isOpen) {
		super();
		this.id = id;
		this.isOpen = isOpen;
	}
    
	public Valve() {
	}
	
	public Valve(Valve valve) {
		super();
		this.id = valve.getId();
		this.isOpen = valve.getIsOpen();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getIsOpen() {
		return isOpen;
	}

	public void setIsOpen(Boolean isOpen) {
		this.isOpen = isOpen;
	}

	
}
