package com.gracehopper.gracehoppermonitorbackend.controller;

import com.gracehopper.gracehoppermonitorbackend.model.Collaborator;
import com.gracehopper.gracehoppermonitorbackend.service.CollaboratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/collaborator")
public class CollaboratorController {

    @Autowired
    CollaboratorService service;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Collaborator> getCollaboratorById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.getCollaboratorById(id));
    }

}
