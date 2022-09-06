package sbnz.integracija.example.service.contract;

import sbnz.integracija.example.model.User;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService  {
	List<User> findAll();

    void delete(Long id);

    void deleteByUsername(String username);

    User findOne(Long id);

    User findByUsername(String username);

    User save(User entity);

    User create(User entity) throws Exception;

}
