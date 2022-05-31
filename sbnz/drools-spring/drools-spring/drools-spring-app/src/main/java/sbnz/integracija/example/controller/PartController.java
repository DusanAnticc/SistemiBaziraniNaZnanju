package sbnz.integracija.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sbnz.integracija.example.facts.Item;
import sbnz.integracija.example.model.Part;
import sbnz.integracija.example.service.implementation.PartService;


@RestController
@CrossOrigin
@RequestMapping(value = "/api/part")
public class PartController {

    @Autowired
    PartService partService;


    @PostMapping(value = "/{partName}")
    public ResponseEntity<Part> addPart(@PathVariable String partName) throws Exception {

        Part part = partService.create(partName);

        return new ResponseEntity<>(part, HttpStatus.CREATED);
    }
    
    
}
