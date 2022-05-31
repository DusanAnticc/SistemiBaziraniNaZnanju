package sbnz.integracija.example.service.contract;

import sbnz.integracija.example.model.Role;

import java.util.List;

public interface IRoleService {
    List<Role> findAll();

    Role findById(Long id);

    Role create(Role role);
}
