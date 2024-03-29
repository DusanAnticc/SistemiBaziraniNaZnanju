package sbnz.integracija.example.service.implementation;

import sbnz.integracija.example.model.Machine;
import sbnz.integracija.example.repository.MachineRepository;
import sbnz.integracija.example.service.contract.IMachineService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MachineService implements IMachineService {

    private final MachineRepository machineRepository;

    public MachineService(MachineRepository machineRepository) {
        this.machineRepository = machineRepository;
    }

    @Override
    public List<Machine> findAll() {
        return this.machineRepository.findAll();
    }

    @Override
    public Machine findById(Long id) {
        return this.machineRepository.findById(id).orElse(null);
    }

    @Override
    public Machine create(Machine machine) {
        return this.machineRepository.save(machine);
    }
}
