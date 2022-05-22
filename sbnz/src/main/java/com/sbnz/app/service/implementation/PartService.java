package com.sbnz.app.service.implementation;

import com.sbnz.app.model.Part;
import com.sbnz.app.repository.PartRepository;
import com.sbnz.app.service.contract.IPartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartService implements IPartService {

    private PartRepository partRepository;

    @Autowired
    public PartService(PartRepository partRepository){
        this.partRepository = partRepository;
    }

    @Override
    public List<Part> findAll() {
        return null;
    }

    @Override
    public Part findById(Integer id) throws Exception {
        return null;
    }

    @Override
    public Part create(String name) throws Exception {
        Part part = new Part();
        part.setName(name);

        partRepository.save(part);
        return part;
    }

    @Override
    public Part update(Part entity) throws Exception {
        return null;
    }

    @Override
    public void delete(Integer id) throws Exception {

    }
}
