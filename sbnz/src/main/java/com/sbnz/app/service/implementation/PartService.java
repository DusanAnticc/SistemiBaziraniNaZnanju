package com.sbnz.app.service.implementation;

import com.sbnz.app.model.Part;
import com.sbnz.app.repository.PartRepository;
import com.sbnz.app.service.contract.IPartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartService implements IPartService {

    private final PartRepository partRepository;

    @Autowired
    public PartService(PartRepository partRepository){
        this.partRepository = partRepository;
    }

    @Override
    public List<Part> findAll() {
        return this.partRepository.findAll();
    }

    @Override
    public Part findById(Long id) {
        return this.partRepository.findById(id).orElse(null);
    }

    @Override
    public Part create(Part part) {
        return this.partRepository.save(part);
    }

}
