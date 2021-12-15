package com.gracehopper.gracehoppermonitorbackend.repository;

import com.gracehopper.gracehoppermonitorbackend.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRepository extends JpaRepository<Log, Integer> {

    @Query(value = "SELECT * FROM log WHERE id_usuario = ?1 ORDER BY cd_log DESC LIMIT 1", nativeQuery = true)
    Log getLastLogByUser(Integer userId);

    @Query(value = "SELECT * FROM log WHERE id_usuario = ?1", nativeQuery = true)
    List<Log> getLogsByUser(Integer userId);

    @Query(value = "SELECT * FROM log WHERE id_usuario = :userId and DATE_FORMAT(dt_log, \"%Y-%m-%d\") like :logDate", nativeQuery = true)
    List<Log> getLogsByUserDate(@Param("userId") Integer userId, @Param("logDate") String logDate);

    @Query(value = "SELECT * FROM log WHERE id_usuario = ?1 " +
            "ORDER BY cd_log DESC, dt_log DESC LIMIT 2", nativeQuery = true)
    List<Log> getLastLogsByUser(Integer userId);
}
