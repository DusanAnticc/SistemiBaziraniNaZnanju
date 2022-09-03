package sbnz.integracija.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sbnz.integracija.example.model.LogTemperatures;
import sbnz.integracija.example.model.SteamMachine;
import sbnz.integracija.example.service.contract.ISteamMachineService;
import sbnz.integracija.example.service.implementation.LogTemperatureService;
import sbnz.integracija.example.service.implementation.SteamMachineService;


@RestController
@CrossOrigin
@RequestMapping(value = "/api/logTemperature")
public class LogTemperatureController {

    @Autowired
    LogTemperatureService logTemperatureService;
    
    @Autowired
    SteamMachineService steamMachineService;
    
    private final KieContainer kieContainer;
    

	@Autowired
	public LogTemperatureController(KieContainer kieContainer,SteamMachineService steamMachineService) {
		this.kieContainer = kieContainer;
		this.steamMachineService = steamMachineService;
	}
	
    @GetMapping(value = "")
    public ResponseEntity<List<LogTemperatures>> getLogs() throws Exception {

      List<LogTemperatures> logs = new ArrayList<LogTemperatures>();
      logs = logTemperatureService.findAll();
      
      List<SteamMachine> machines = new ArrayList<SteamMachine>();
      machines = steamMachineService.findAll();

      KieSession kieSession = kieContainer.newKieSession("reporSuspiciousBehavior");
      
      for (int j = 0; j < machines.size(); j++) {
    	  kieSession.insert(machines.get(j));
    	}

      for(LogTemperatures log: logs) {
    	  kieSession.insert(log);
      }
      kieSession.fireAllRules();

      kieSession.dispose();
      return new ResponseEntity<>(logs, HttpStatus.CREATED);
    }
    

}
