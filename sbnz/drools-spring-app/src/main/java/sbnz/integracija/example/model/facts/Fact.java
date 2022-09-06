package sbnz.integracija.example.model.facts;

public abstract class Fact {

	private Long idMachine;

	public Fact(Long idMachine) {
		super();
		this.idMachine = idMachine;
	}
	
	public Fact() {
	}

	public Long getIdMachine() {
		return idMachine;
	}

	public void setIdMachine(Long idMachine) {
		this.idMachine = idMachine;
	}
	
	
}
