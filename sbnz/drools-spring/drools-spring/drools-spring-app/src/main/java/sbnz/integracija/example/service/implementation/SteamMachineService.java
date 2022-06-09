package sbnz.integracija.example.service.implementation;

import java.util.List;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sbnz.integracija.example.model.SteamMachine;
import sbnz.integracija.example.repository.SteamMachineRepository;
import sbnz.integracija.example.service.contract.ISteamMachineService;

@Service
public class SteamMachineService implements ISteamMachineService {

    private final SteamMachineRepository steamMachineRepository;

    private final KieContainer kieContainer;


    @Autowired
    public SteamMachineService(SteamMachineRepository steamMachineRepository, KieContainer kieContainer){
        this.steamMachineRepository = steamMachineRepository;
        this.kieContainer = kieContainer;
    }


	@Override
	public List<SteamMachine> findAll() {
		return this.steamMachineRepository.findAll();
	}


	@Override
	public SteamMachine findById(Long id) {
		return this.steamMachineRepository.findById(id).orElse(null);
	}


	@Override
	public SteamMachine create(SteamMachine steamMachine) {
		return this.steamMachineRepository.save(steamMachine);
	}


	@Override
	public SteamMachine updateSteamValue(Long id, Long steamValue) {
		SteamMachine steamMachine = this.findById(id);
		steamMachine.setCurrentSteamValue(steamValue);
		
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(steamMachine);
		kieSession.fireAllRules();
		kieSession.dispose();
		return this.steamMachineRepository.save(steamMachine);
	}
   
}
