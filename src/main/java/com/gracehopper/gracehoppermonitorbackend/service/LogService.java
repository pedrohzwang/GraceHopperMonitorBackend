package com.gracehopper.gracehoppermonitorbackend.service;

import com.gracehopper.gracehoppermonitorbackend.model.Log;
import com.gracehopper.gracehoppermonitorbackend.model.User;
import com.gracehopper.gracehoppermonitorbackend.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Service
public class LogService {

    @Autowired
    LogRepository repository;

    public Log saveLog(Log log) {
        //System.out.println(log.toString());
        return repository.save(log);
    }

    public List<Log> getLogsByUser(User user) {
        return repository.getLogsByUser(user.getUserId());
    }

    public Log getLastLogByUser(User user) {
        return repository.getLastLogByUser(user.getUserId());
    }

    public void getInactiveTimeByUser(User user) {
        List<Log> logs = repository.getLastLogsByUser(user.getUserId());
        Instant lastLogTime = logs.get(0).getLogDate().atZone(ZoneId.systemDefault()).toInstant();
        Instant penultimateLogTime = logs.get(1).getLogDate().atZone(ZoneId.systemDefault()).toInstant();

        //return lastLogTime.m
    }

    public Log getLogByCode(Long logCode) {
        return repository.getById(logCode);
    }
}
