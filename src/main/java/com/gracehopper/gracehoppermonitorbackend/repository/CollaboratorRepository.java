package com.gracehopper.gracehoppermonitorbackend.repository;

import com.gracehopper.gracehoppermonitorbackend.model.Collaborator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollaboratorRepository extends JpaRepository<Collaborator, Long> {
}
