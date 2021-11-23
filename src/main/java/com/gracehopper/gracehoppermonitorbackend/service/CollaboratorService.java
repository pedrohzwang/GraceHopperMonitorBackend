package com.gracehopper.gracehoppermonitorbackend.service;

import com.gracehopper.gracehoppermonitorbackend.model.Collaborator;
import com.gracehopper.gracehoppermonitorbackend.repository.CollaboratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollaboratorService {

    @Autowired
    CollaboratorRepository repository;

    public Collaborator getCollaboratorById(Long id) {
        return repository.getById(id);
    }
}
