package com.gracehopper.gracehoppermonitorbackend.repository;

import com.gracehopper.gracehoppermonitorbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * FROM usuario WHERE nome_usuario = ?1", nativeQuery = true)
    List<User> existsUserByUsername(String userName);
}
