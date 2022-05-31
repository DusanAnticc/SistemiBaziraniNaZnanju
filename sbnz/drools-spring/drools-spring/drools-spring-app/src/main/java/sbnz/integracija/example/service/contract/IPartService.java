package sbnz.integracija.example.service.contract;

import sbnz.integracija.example.model.Part;

import java.util.List;

public interface IPartService {

    List<Part> findAll();

    Part findById(Long id);

    Part create(Part part);
}
