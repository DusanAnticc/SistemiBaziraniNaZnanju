package com.sbnz.app.service.implementation;

import com.sbnz.app.model.Log;
import com.sbnz.app.repository.LogRepository;
import com.sbnz.app.service.contract.ILogService;
import org.springframework.stereotype.Service;

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
}
