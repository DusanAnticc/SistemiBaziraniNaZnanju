package sbnz.integracija.example.controller;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sbnz.integracija.example.facts.Item;
import sbnz.integracija.example.model.SteamMachine;
import sbnz.integracija.example.service.contract.ISteamMachineService;
import sbnz.integracija.example.service.implementation.SampleAppService;


@RestController
@CrossOrigin
@RequestMapping(value = "/api/steam-machine")
public class SteamMachineController {

	@Autowired
    ISteamMachineService steamMachineService;
	
	@Autowired
    SampleAppService sampleService;

	    
	 
    @Autowired
    public SteamMachineController(ISteamMachineService steamMachineService, SampleAppService sampleService) {
		super();
		this.steamMachineService = steamMachineService;
		this.sampleService = sampleService;
	}


    @RequestMapping(value = "/update/{id}/{steamValue}", method = RequestMethod.GET, produces = "application/json")
    public SteamMachine updateSteamMachineSteamValue(@PathVariable Long id, @PathVariable Long steamValue) throws Exception {

        return this.steamMachineService.updateSteamValue(id, steamValue);
    }
	
	@RequestMapping(value = "/item", method = RequestMethod.GET, produces = "application/json")
	public Item getQuestions(@RequestParam(required = true) String id, @RequestParam(required = true) String name,
			@RequestParam(required = true) double cost, @RequestParam(required = true) double salePrice) {

		Item newItem = new Item(Long.parseLong(id), name, cost, salePrice);

		Item i2 = sampleService.getClassifiedItem(newItem);

		return i2;
	}
}
