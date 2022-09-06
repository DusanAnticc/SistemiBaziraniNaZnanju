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

import sbnz.integracija.example.model.Log;
import sbnz.integracija.example.model.LogTemperatures;
import sbnz.integracija.example.model.ServiceLog;
import sbnz.integracija.example.model.SteamMachine;
import sbnz.integracija.example.model.WaterTank;
import sbnz.integracija.example.repository.SteamMachineRepository;
import sbnz.integracija.example.service.contract.ISteamMachineService;
import sbnz.integracija.example.service.implementation.LogService;
import sbnz.integracija.example.service.implementation.ServiceLogService;


@RestController
@CrossOrigin
@RequestMapping(value = "/api/log")
public class LogController {

    @Autowired
    LogService logService;
    
    @Autowired
    ServiceLogService serviceLogService;
    
    private final ISteamMachineService steamMachineService;
    
    private final KieContainer kieContainer;

	@Autowired
	public LogController(KieContainer kieContainer, ISteamMachineService steamMachineService) {
		this.kieContainer = kieContainer;
		this.steamMachineService = steamMachineService;
	}

	
    @GetMapping(value = "")
    public ResponseEntity<List<Log>> getLogs() throws Exception {

      List<Log> logs = new ArrayList();
      logs = logService.findAll();
      
      List<ServiceLog> servicelogs = new ArrayList();
      servicelogs = serviceLogService.findAll();
      
      List<SteamMachine> machines = new ArrayList();
      machines = steamMachineService.findAll();
      
      KieSession kieSession = kieContainer.newKieSession("reporSuspiciousBehavior");
      //kieSession.getAgenda().getAgendaGroup("reportLogs").setFocus();
      kieSession.getAgenda().getAgendaGroup("report").setFocus();
      for (int j = 0; j < machines.size(); j++) {
    	  kieSession.insert(machines.get(j));
    	}

      for(Log log: logs) {
    	  kieSession.insert(log);
      }
      
      for(ServiceLog servicelog: servicelogs) {
    	  kieSession.insert(servicelog);
      }
      
//      WaterTank wt = machines.get(0).getWaterTank();
//      kieSession.insert(wt);
    
      kieSession.fireAllRules();

      kieSession.dispose();
      return new ResponseEntity<>(logs, HttpStatus.CREATED);
    }
    

}
