package sbnz.app.service.implementation;

import sbnz.app.model.Part;
import sbnz.app.repository.PartRepository;
import sbnz.app.service.contract.IPartService;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

        /*KieSession kieSession = kieContainer.newKieSession("ruleSession");
        kieSession.insert(part);
        kieSession.fireAllRules();
        kieSession.dispose();
*/
        partRepository.save(part);
        return part;
    }


}
