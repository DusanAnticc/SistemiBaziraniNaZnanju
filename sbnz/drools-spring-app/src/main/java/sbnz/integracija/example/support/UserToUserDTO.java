package sbnz.integracija.example.support;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import sbnz.integracija.example.dto.UserDTO;
import sbnz.integracija.example.model.Guest;
import sbnz.integracija.example.model.User;
import sbnz.integracija.example.model.Worker;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserToUserDTO implements Converter<User, UserDTO> {
    @Override
    public UserDTO convert(User user) {
        UserDTO dto = new UserDTO();
        dto.setDeleted(user.getDeleted());
        dto.setEmail(user.getEmail());
        dto.setLastName(user.getLastName());
        dto.setFirstName(user.getFirstName());
        dto.setPassword(user.getPassword());
        dto.setUsername(user.getUsername());
        dto.setProsecuted(user.isProsecuted());
        if(user.getPenalty() != null) dto.setPenalty(user.getPenalty());
        
        String dtype = "";
        Long energyProduced = null;
    	String category = null;
    	Long discount = null;
    	Long owes = null;

        if(user instanceof Worker) dtype = "Worker";
        
        if(user instanceof Guest) {
        	dtype = "Guest";
        	energyProduced = ((Guest) user).getEnergyProduced();
        	category = ((Guest) user).getCategory().toString();
        	discount = ((Guest) user).getDiscount();
        	owes = ((Guest) user).getOwes();
        }

        dto.setDtype(dtype);
        dto.setEnergyProduced(energyProduced);
        dto.setCategory(category);
        dto.setDiscount(discount);
        dto.setOwes(owes);
        
        return dto;
    }

    public List<UserDTO> convert(List<User> users){
        List<UserDTO> dtos = new ArrayList<>();

        for(User u : users) dtos.add(this.convert(u));

        return dtos;
    }
}
