package sbnz.integracija.example.service.contract;


import sbnz.integracija.example.model.LogTemperatures;

import java.util.List;

public interface ILogTemperatureService {
    List<LogTemperatures> findAll();

    LogTemperatures findById(Long id);

    LogTemperatures create(LogTemperatures log);
}
