package sbnz.integracija.example.service.implementation;

import sbnz.integracija.example.model.LogTemperatures;
import sbnz.integracija.example.repository.LogTemperatureRepository;
import sbnz.integracija.example.service.contract.ILogTemperatureService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogTemperatureService implements ILogTemperatureService {

    private final LogTemperatureRepository logTemperaturesRepository;

    public LogTemperatureService(LogTemperatureRepository logTemperaturesRepository) {
        this.logTemperaturesRepository = logTemperaturesRepository;
    }

    @Override
    public List<LogTemperatures> findAll() {
    	return this.logTemperaturesRepository.findAll();
    }

    @Override
    public LogTemperatures findById(Long id) {
        return this.logTemperaturesRepository.findById(id).orElse(null);
    }

    @Override
    public LogTemperatures create(LogTemperatures log) {
        return this.logTemperaturesRepository.save(log);
    }
}
