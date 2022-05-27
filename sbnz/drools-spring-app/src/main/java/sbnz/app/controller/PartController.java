package sbnz.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sbnz.app.model.Part;
import sbnz.app.service.implementation.PartService;


@RestController
@RequestMapping(value = "/api/v1/part")
public class PartController {

    @Autowired
    PartService partService;


    @PostMapping(value = "")
    public ResponseEntity<Part> addPart(@RequestBody String partName) throws Exception {

        Part part = partService.create(partName);


        return new ResponseEntity<>(part, HttpStatus.CREATED);
    }
}
