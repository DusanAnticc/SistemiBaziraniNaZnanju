package sbnz.integracija.example.model;

import java.util.Date;

import javax.persistence.EnumType;

import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import sbnz.integracija.example.model.enums.State;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;


@Role(Role.Type.EVENT)
@Timestamp("executionTime")
@Expires("2h30m")
public class Symptom {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private boolean pumpNotWorking;
	private boolean valveLeaking;
	private boolean valveDestoyed;
	private boolean Smoke;
	private boolean loudSound;
	@Enumerated(EnumType.STRING)
	private State machineState;
	
	private Date executionTime;
	
	public Symptom() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public boolean isPumpNotWorking() {
		return pumpNotWorking;
	}
	public void setPumpNotWorking(boolean pumpNotWorking) {
		this.pumpNotWorking = pumpNotWorking;
	}
	public boolean isValveLeaking() {
		return valveLeaking;
	}
	public void setValveLeaking(boolean valveLeaking) {
		this.valveLeaking = valveLeaking;
	}
	public boolean isValveDestoyed() {
		return valveDestoyed;
	}
	public void setValveDestoyed(boolean valveDestoyed) {
		this.valveDestoyed = valveDestoyed;
	}
	public boolean isSmoke() {
		return Smoke;
	}
	public void setSmoke(boolean smoke) {
		Smoke = smoke;
	}
	public boolean isLoudSound() {
		return loudSound;
	}
	public void setLoudSound(boolean loudSound) {
		this.loudSound = loudSound;
	}
	public State getMachineState() {
		return machineState;
	}
	public void setMachineState(State machineState) {
		this.machineState = machineState;
	}
	
	
}