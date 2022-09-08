package sbnz.integracija.example.controller;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sbnz.integracija.example.model.Guest;
import sbnz.integracija.example.model.enums.ManufactureType;
import sbnz.integracija.example.repository.UserRepository;
import sbnz.integracija.example.service.implementation.GuestService;
import sbnz.integracija.example.service.implementation.UserService;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/guest")
public class GuestController {

	@Autowired
	GuestService guestService;
	@Autowired
	UserService userService;
	
    private final KieContainer kieContainer;
	
	@Autowired
	public GuestController(KieContainer kieContainer,GuestService guestService,UserService userService ) {
		this.kieContainer = kieContainer;
		this.guestService=guestService;
		this.userService=userService;
	}
	
	@PostMapping(value = "/payBill/{userId}")
    public Long payBill(@PathVariable Long userId) {

		KieSession kieSession = kieContainer.newKieSession("reporSuspiciousBehavior");
		kieSession.getAgenda().getAgendaGroup("guest").setFocus();
		Guest user = (Guest) userService.findOne(userId);

		kieSession.insert(user);
		Long paid = guestService.PayBill(userId);
		
	    kieSession.fireAllRules();

	    kieSession.dispose();
		
		return paid;
    }
	
	@PostMapping(value = "/producedEnergy/{userId}/{value}")
    public ManufactureType producedEnergy(@PathVariable Long userId,@PathVariable Long value) {

		KieSession kieSession = kieContainer.newKieSession("reporSuspiciousBehavior");
		kieSession.getAgenda().getAgendaGroup("guest").setFocus();
		Guest user = (Guest) userService.findOne(userId);
		
		Long energy = guestService.setProducedEnergy(userId,value);
		kieSession.insert(user);
		
		kieSession.fireAllRules();

	    kieSession.dispose();
		
		return user.getCategory();
    }
}
