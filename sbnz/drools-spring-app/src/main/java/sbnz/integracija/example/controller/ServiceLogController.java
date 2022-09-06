package sbnz.integracija.example.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sbnz.integracija.example.model.ServiceLog;
import sbnz.integracija.example.model.SteamMachine;
import sbnz.integracija.example.service.contract.IServiceLogService;
import sbnz.integracija.example.service.contract.ISteamMachineService;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/service-log")
public class ServiceLogController {

    private final ISteamMachineService steamMachineService;
    private final IServiceLogService serviceLogService;
    
    @Autowired
    public ServiceLogController(ISteamMachineService steamMachineService, IServiceLogService serviceLogService) {
    	this.steamMachineService = steamMachineService;
    	this.serviceLogService = serviceLogService;
    }


    @PostMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<ServiceLog> createServiceLog(@PathVariable Long id) throws Exception {

        SteamMachine steamMachine = this.steamMachineService.findById(id);
        ServiceLog serviceLog = new ServiceLog();
        Date date = new Date();
        serviceLog.setExecutionTime(date.getTime());
        serviceLog.setSteamMachine(steamMachine);
        
        this.serviceLogService.create(serviceLog);

        return new ResponseEntity<>(serviceLog, HttpStatus.CREATED);
    }
    
    
}