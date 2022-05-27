package sbnz.app.service.contract;

import sbnz.app.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    User findById(Long id);

    User create(User user);
}
