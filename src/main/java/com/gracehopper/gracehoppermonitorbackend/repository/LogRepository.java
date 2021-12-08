package com.gracehopper.gracehoppermonitorbackend.repository;

import com.gracehopper.gracehoppermonitorbackend.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {

    @Query(value = "SELECT MAX(CD_LOG) FROM log WHERE user_id = ?1", nativeQuery = true)
    Log getLastLogByUser(Long userId);

    @Query(value = "SELECT * FROM log WHERE user_id = ?1", nativeQuery = true)
    List<Log> getLogsByUser(Long userId);

    @Query(value = "SELECT * FROM log WHERE id_usuario = ?1 ORDER BY cd_log DESC, dt_log DESC LIMIT 2", nativeQuery = true)
    List<Log> getLastLogsByUser(Long userId);
}
