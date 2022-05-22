package com.sbnz.app.service.implementation;

import com.sbnz.app.model.Role;
import com.sbnz.app.repository.RoleRepository;
import com.sbnz.app.service.contract.IRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements IRoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> findAll() {
        return this.roleRepository.findAll();
    }

    @Override
    public Role findById(Long id) {
        return this.roleRepository.findById(id).orElse(null);
    }

    @Override
    public Role create(Role role) {
        return this.roleRepository.save(role);
    }
}
