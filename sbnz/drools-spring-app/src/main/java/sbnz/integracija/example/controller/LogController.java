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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sbnz.integracija.example.model.Log;
import sbnz.integracija.example.model.SteamMachine;
import sbnz.integracija.example.service.contract.ILogService;
import sbnz.integracija.example.service.contract.ISteamMachineService;


@RestController
@CrossOrigin
@RequestMapping(value = "/api/log")
public class LogController {

    @Autowired
    ILogService logService;
    
    private final ISteamMachineService steamMachineService;
    
    private final KieContainer kieContainer;

	@Autowired
	public LogController(KieContainer kieContainer, ISteamMachineService steamMachineService) {
		this.kieContainer = kieContainer;
		this.steamMachineService = steamMachineService;
	}

	
    @GetMapping(value = "")
    public ResponseEntity<List<Log>> getLogs() throws Exception {

      List<Log> logs = new ArrayList<Log>();
      logs = logService.findAll();
      
      List<SteamMachine> machines = new ArrayList<SteamMachine>();
      machines = steamMachineService.findAll();
      
      KieSession kieSession = kieContainer.newKieSession("reporSuspiciousBehavior");
      
      
      for (int j = 0; j < machines.size(); j++) {
    	  kieSession.insert(machines.get(j));
    	}

      for(Log log: logs) {
    	  kieSession.insert(log);
      }
      kieSession.fireAllRules();

      kieSession.dispose();
      return new ResponseEntity<>(logs, HttpStatus.CREATED);
    }
    
	
    @GetMapping(value = "/machine/{id}", produces = "application/json")
    public ResponseEntity<List<Log>> getLogsByMachine(@PathVariable Long id) throws Exception {

      List<Log> logs = new ArrayList<Log>();
      logs = logService.findAllByMachineId(id);
      
      SteamMachine machine = steamMachineService.findById(id);
      
      KieSession kieSession = kieContainer.newKieSession("reporSuspiciousBehavior");
      
	  kieSession.insert(machine);

      for(Log log: logs) {
    	  kieSession.insert(log);
      }
      
      kieSession.fireAllRules();

      kieSession.dispose();
      return new ResponseEntity<>(logs, HttpStatus.CREATED);
    }
    

}
