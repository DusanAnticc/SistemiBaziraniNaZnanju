package sbnz.app.service.contract;

import sbnz.app.model.Role;

import java.util.List;

public interface IRoleService {
    List<Role> findAll();

    Role findById(Long id);

    Role create(Role role);
}
