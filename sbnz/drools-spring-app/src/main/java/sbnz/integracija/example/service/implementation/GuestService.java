package sbnz.integracija.example.service.implementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sbnz.integracija.example.model.Guest;
import sbnz.integracija.example.repository.UserRepository;
import sbnz.integracija.example.service.contract.IGuestService;

@Service
public class GuestService implements IGuestService {

	private final UserRepository userRepository;

    public GuestService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Override
    public Long PayBill(Long userId)
    {
    	Guest user = (Guest) userRepository.findById(userId).orElse(null);

    	if(user.getCategory()==null)
    	{
    		Long owes = user.getOwes();
    		user.setOwes((long) 0);
    		userRepository.save(user);
    		return owes;
    	}
    	else
    	{
    		Long owes = user.getOwes()*(1/user.getDiscount());
    		user.setOwes((long) 0);
    		userRepository.save(user);
    		return owes;
    	}
    }
}
