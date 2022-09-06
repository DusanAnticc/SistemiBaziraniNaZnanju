package sbnz.integracija.example.service.implementation;

import sbnz.integracija.example.model.LogTemperatures;
import sbnz.integracija.example.model.template.TemplateModel;
import sbnz.integracija.example.repository.LogTemperatureRepository;
import sbnz.integracija.example.service.contract.ILogTemperatureService;

import org.drools.template.ObjectDataCompiler;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

//import com.sun.org.slf4j.internal.Logger;
//import com.sun.org.slf4j.internal.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@Service
public class LogTemperatureService implements ILogTemperatureService {

    private final LogTemperatureRepository logTemperaturesRepository;
    
  //  Logger log = org.slf4j.LoggerFactory.getLogger(LogTemperatureService.class);

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
    
    public String compileTemplate(List<Long> idMachines, Double lowerLimit, Double upperLimit) {
        List<TemplateModel> templateModels = new ArrayList<>();
        for (Long id : idMachines) {
            templateModels.add(new TemplateModel(id, lowerLimit, upperLimit));
        }
        
        System.out.println("idMachinesLength: " + idMachines.size());
        System.out.println("== TEMPLATE ==");
        try (InputStream inputStream = new FileInputStream("C:\\Users\\Dusan\\Desktop\\SistemiBaziraniNaZnanju\\sbnz\\drools-spring-kjar\\src\\main\\resources\\sbnz\\template\\template.drt")) {
            ObjectDataCompiler compiler = new ObjectDataCompiler();
            String drl = compiler.compile(templateModels, inputStream);
            System.out.println("Compilation successful.");
            System.out.println(drl);
            
            FileOutputStream outputStream = new FileOutputStream(new File("C:\\Users\\Dusan\\Desktop\\compiledRules.drl"));
            outputStream.write(drl.getBytes());
            outputStream.close();
            
            return drl;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
