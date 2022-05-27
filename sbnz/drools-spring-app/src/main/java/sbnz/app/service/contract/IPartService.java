package sbnz.app.service.contract;

import sbnz.app.model.Part;

import java.util.List;

public interface IPartService {

    List<Part> findAll();

    Part findById(Long id);

    Part create(Part part);
}
