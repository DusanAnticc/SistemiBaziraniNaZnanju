package sbnz.app.service.contract;

import sbnz.app.model.Machine;

import java.util.List;

public interface IMachineService {
    List<Machine> findAll();

    Machine findById(Long id);

    Machine create(Machine machine);
}
