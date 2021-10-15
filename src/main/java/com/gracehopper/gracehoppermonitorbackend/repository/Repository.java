package com.gracehopper.gracehoppermonitorbackend.repository;

import com.gracehopper.gracehoppermonitorbackend.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Log, Integer> {
}
