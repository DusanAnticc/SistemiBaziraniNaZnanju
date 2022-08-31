package sbnz.integracija.example.service.implementation;

import java.util.List;

import org.kie.api.runtime.KieContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sbnz.integracija.example.model.Part;
import sbnz.integracija.example.repository.PartRepository;
import sbnz.integracija.example.service.contract.IPartService;

@Service
public class PartService implements IPartService {

    private final PartRepository partRepository;

    private final KieContainer kieContainer;


    @Autowired
    public PartService(PartRepository partRepository, KieContainer kieContainer){
        this.partRepository = partRepository;
        this.kieContainer = kieContainer;
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
        return null;
    }


    public Part create(String name) throws Exception {

        Part part = new Part();
        part.setName(name);

        partRepository.save(part);
        return part;
    }


}
