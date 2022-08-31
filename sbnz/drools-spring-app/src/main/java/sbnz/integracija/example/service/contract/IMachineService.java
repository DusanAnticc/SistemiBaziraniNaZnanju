package sbnz.integracija.example.service.contract;

import sbnz.integracija.example.model.Machine;

import java.util.List;

public interface IMachineService {
    List<Machine> findAll();

    Machine findById(Long id);

    Machine create(Machine machine);
}
