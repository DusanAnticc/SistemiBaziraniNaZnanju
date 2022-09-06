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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sbnz.integracija.example.model.Log;
import sbnz.integracija.example.model.ServiceLog;
import sbnz.integracija.example.model.SteamMachine;
import sbnz.integracija.example.service.contract.IGuestService;
import sbnz.integracija.example.service.contract.ISteamMachineService;
import sbnz.integracija.example.service.implementation.GuestService;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/guest")
public class GuestController {

	@Autowired
	GuestService guestService;
	
	@Autowired
	public GuestController(GuestService guestService ) {
		this.guestService=guestService;
	}
	
	@PostMapping(value = "/payBill/{userId}")
    public Long payBill(@PathVariable Long userId) {

		Long paid = guestService.PayBill(userId);
		return paid;
    }
}
