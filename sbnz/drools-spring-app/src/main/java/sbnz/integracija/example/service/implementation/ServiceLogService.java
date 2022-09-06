package sbnz.integracija.example.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import sbnz.integracija.example.model.ServiceLog;
import sbnz.integracija.example.repository.ServiceLogRepository;
import sbnz.integracija.example.service.contract.IServiceLogService;

@Service
public class ServiceLogService implements IServiceLogService{

	 private final ServiceLogRepository logRepository;

	    public ServiceLogService(ServiceLogRepository logRepository) {
	        this.logRepository = logRepository;
	    }

	    @Override
	    public List<ServiceLog> findAll() {
	        return this.logRepository.findAll();
	    }

	    @Override
	    public ServiceLog findById(Long id) {
	        return this.logRepository.findById(id).orElse(null);
	    }

	    @Override
	    public ServiceLog create(ServiceLog log) {
	        return this.logRepository.save(log);
	    }
}
