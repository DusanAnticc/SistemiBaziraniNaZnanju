package sbnz.integracija.example.service.implementation;

import sbnz.integracija.example.model.Log;
import sbnz.integracija.example.repository.LogRepository;
import sbnz.integracija.example.service.contract.ILogService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LogService implements ILogService {

    private final LogRepository logRepository;

    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Override
    public List<Log> findAll() {
        return this.logRepository.findAll();
    }

    @Override
    public Log findById(Long id) {
        return this.logRepository.findById(id).orElse(null);
    }

    @Override
    public Log create(Log log) {
        return this.logRepository.save(log);
    }

	@Override
	public List<Log> findAllByMachineId(Long machineId) {
		List<Log> foundLogs = new ArrayList<Log>();
		
		List<Log> logs = this.findAll();
		
		for (Log log: logs) {
			if (log.getSteamMachine().getId() == machineId) {
				foundLogs.add(log);
			}
		}
		return foundLogs;
	}
}
