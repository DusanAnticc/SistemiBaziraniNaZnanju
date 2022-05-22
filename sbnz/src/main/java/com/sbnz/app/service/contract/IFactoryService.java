package com.sbnz.app.service.contract;

import com.sbnz.app.model.Factory;

import java.util.List;

public interface IFactoryService {

    List<Factory> findAll();

    Factory findById(Long id);

    Factory create(Factory factory);
}
