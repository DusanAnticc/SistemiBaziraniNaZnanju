package sbnz.integracija.example.service.contract;


import java.util.List;

import sbnz.integracija.example.model.Factory;

public interface IFactoryService {

    List<Factory> findAll();

    Factory findById(Long id);

    Factory create(Factory factory);
}
