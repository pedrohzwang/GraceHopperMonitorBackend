package com.gracehopper.gracehoppermonitorbackend.service;

import com.gracehopper.gracehoppermonitorbackend.model.Log;
import com.gracehopper.gracehoppermonitorbackend.model.User;
import com.gracehopper.gracehoppermonitorbackend.repository.LogRepository;
import com.gracehopper.gracehoppermonitorbackend.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
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
        LocalDateTime lastLogTime = logs.get(0).getLogDate();
        LocalDateTime penultimateLogTime = logs.get(1).getLogDate();

        System.out.println(penultimateLogTime.until(lastLogTime, ChronoUnit.MINUTES));

        //return lastLogTime.m
    }

    public Log getLogByCode(Integer logCode) {
        return repository.getById(logCode);
    }

    public String getLogsCsvByUser(Integer userId) {
        return LogUtils.formatLogCsv(repository.getLogsByUser(userId));
    }


}
