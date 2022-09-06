package sbnz.integracija.example.service.implementation;

import sbnz.integracija.example.model.User;
import sbnz.integracija.example.repository.UserRepository;
import sbnz.integracija.example.service.contract.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

import java.util.List;

@Service
public class UserService implements IUserService {

	private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(s);
        if (user == null) {
            try {
				throw new NotFoundException("No user found for "+ s + ".");
			} catch (NotFoundException e) {
				e.printStackTrace();
			}
        }
        return user;
    }
    
    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        User user = this.findOne(id);
        user.setDeleted(true);
        this.save(user);
    }

    @Override
    public void deleteByUsername(String username) {
        User user = this.findByUsername(username);
        user.setDeleted(true);
        this.save(user);
    }

    @Override
    public User findOne(Long id) {
        return this.userRepository.findById(id).orElse(null);
    }

    @Override
    public User findByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public User save(User entity) {
        return this.userRepository.save(entity);
    }

    @Override
    public User create(User entity) throws Exception {
    	
    	userRepository.save(entity);
        return entity;
    }
    
    public String hashPassword(String pass) {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        return bCryptPasswordEncoder.encode(pass);
    }

}
