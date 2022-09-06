package sbnz.integracija.example.service.contract;


import sbnz.integracija.example.model.Log;

import java.util.List;

public interface ILogService {
    List<Log> findAll();

    Log findById(Long id);

    Log create(Log log);
    
    List<Log> findAllByMachineId(Long machineId);
}
