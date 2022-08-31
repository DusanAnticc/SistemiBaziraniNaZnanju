package sbnz.integracija.example.service.contract;

import sbnz.integracija.example.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    User findById(Long id);

    User create(User user);
}
