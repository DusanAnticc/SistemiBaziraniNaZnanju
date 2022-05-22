package com.sbnz.app.service.implementation;

import com.sbnz.app.model.Factory;
import com.sbnz.app.repository.FactoryRepository;
import com.sbnz.app.service.contract.IFactoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FactoryService implements IFactoryService {

    private final FactoryRepository factoryRepository;

    public FactoryService(FactoryRepository factoryRepository) {
        this.factoryRepository = factoryRepository;
    }

    @Override
    public List<Factory> findAll() {
        return this.factoryRepository.findAll();
    }

    @Override
    public Factory findById(Long id) {
        return this.factoryRepository.findById(id).orElse(null);
    }

    @Override
    public Factory create(Factory factory) {
        return this.factoryRepository.save(factory);
    }

}
