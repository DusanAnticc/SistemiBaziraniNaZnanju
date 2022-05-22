package com.sbnz.app.controller;

import com.sbnz.app.model.Part;
import com.sbnz.app.service.implementation.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/part")
public class PartController {

    @Autowired
    PartService partService;

    @PostMapping(value = "")
    public ResponseEntity<Part> addPart(@RequestBody String PartName) throws Exception {



        return new ResponseEntity<>( HttpStatus.CREATED);
    }
}
