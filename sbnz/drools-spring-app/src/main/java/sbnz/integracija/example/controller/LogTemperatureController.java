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
import sbnz.integracija.example.service.contract.ISteamMachineService;
import sbnz.integracija.example.service.implementation.LogTemperatureService;


@RestController
@CrossOrigin
@RequestMapping(value = "/api/logTemperature")
public class LogTemperatureController {

    @Autowired
    LogTemperatureService logTemperatureService;
    
    private final KieContainer kieContainer;

	@Autowired
	public LogTemperatureController(KieContainer kieContainer, ISteamMachineService steamMachineService) {
		this.kieContainer = kieContainer;
	}

	
    @GetMapping(value = "")
    public ResponseEntity<List<LogTemperatures>> getLogs() throws Exception {

      List<LogTemperatures> logs = new ArrayList<LogTemperatures>();
      logs = logTemperatureService.findAll();
      
      KieSession kieSession = kieContainer.newKieSession("reporSuspiciousBehavior");
      
      kieSession.insert(logs.get(0));
      kieSession.insert(logs.get(1));
      kieSession.insert(logs.get(2));
      kieSession.insert(logs.get(3));
      kieSession.insert(logs.get(4));

      
      kieSession.getAgenda().getAgendaGroup("MeasuredTemperature").setFocus();
      int i = kieSession.fireAllRules();
      kieSession.dispose();
      return new ResponseEntity<>(logs, HttpStatus.CREATED);
    }
    

}
