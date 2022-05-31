package sbnz.integracija.example.service.contract;

import sbnz.integracija.example.model.SteamMachine;

import java.util.List;

public interface ISteamMachineService {

    List<SteamMachine> findAll();

    SteamMachine findById(Long id);

    SteamMachine create(SteamMachine steamMachine);
    
    SteamMachine updateSteamValue(Long id, Long steamValue);
}
