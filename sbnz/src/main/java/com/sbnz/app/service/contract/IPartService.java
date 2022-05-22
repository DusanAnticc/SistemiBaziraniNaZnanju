package com.sbnz.app.service.contract;

import com.sbnz.app.model.Part;

import java.util.List;

public interface IPartService {

    List<Part> findAll();

    Part findById(Integer id) throws Exception;

    Part create(String entity) throws Exception;

    Part update(Part entity) throws Exception;

    void delete(Integer id) throws Exception;
}
