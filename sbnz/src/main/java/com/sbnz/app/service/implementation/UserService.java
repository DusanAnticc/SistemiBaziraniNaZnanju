package com.sbnz.app.service.implementation;

import com.sbnz.app.model.User;
import com.sbnz.app.repository.UserRepository;
import com.sbnz.app.service.contract.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return this.userRepository.findById(id).orElse(null);
    }

    @Override
    public User create(User user) {
        return this.userRepository.save(user);
    }
}
