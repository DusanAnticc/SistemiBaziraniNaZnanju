package sbnz.integracija.example.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Factory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    private String name;

    @OneToMany()
    @JoinColumn(name = "user_id")
    private List<User> staff;

    @OneToMany()
    @JoinColumn(name = "factory_id")
    private List<SteamMachine> machines;

	public Factory() {
		
	}

	public Factory(Long id, String name, List<User> staff, List<SteamMachine> machines) {
		super();
		this.id = id;
		this.name = name;
		this.staff = staff;
		this.machines = machines;
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

	public List<User> getStaff() {
		return staff;
	}

	public void setStaff(List<User> staff) {
		this.staff = staff;
	}

	public List<SteamMachine> getMachines() {
		return machines;
	}

	public void setMachines(List<SteamMachine> machines) {
		this.machines = machines;
	}
    
    

}
