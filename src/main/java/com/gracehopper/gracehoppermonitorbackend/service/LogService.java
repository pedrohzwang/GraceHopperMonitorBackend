package com.gracehopper.gracehoppermonitorbackend.service;

import com.gracehopper.gracehoppermonitorbackend.dto.LogDTO;
import com.gracehopper.gracehoppermonitorbackend.model.Log;
import com.gracehopper.gracehoppermonitorbackend.model.User;
import com.gracehopper.gracehoppermonitorbackend.repository.LogRepository;
import com.gracehopper.gracehoppermonitorbackend.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class LogService {

    @Autowired
    LogRepository repository;
    private static final Integer MONITORING_INTERVAL = 10;

    public Log saveLog(Log log) {
        return repository.save(log);
    }

    public List<LogDTO> getLogsByUser(Integer userId) {
        List<Log> logs = repository.getLogsByUser(userId);
        List<LogDTO> logsDTO = new ArrayList<>();
        logs.stream().forEach(log -> {
            logsDTO.add(new LogDTO(log));
        });
        return logsDTO;
    }

    public Log getLastLogByUser(User user) {
        return repository.getLastLogByUser(user.getUserId());
    }

    public Long getInactiveTimeByUser(Integer userId) {
        List<Log> logs = repository.getLastLogsByUser(userId);
        LocalDateTime lastLogTime = logs.get(0).getLogDate();
        LocalDateTime penultimateLogTime = logs.get(1).getLogDate();
        Long diff = penultimateLogTime.until(lastLogTime, ChronoUnit.MINUTES);

        return (diff - MONITORING_INTERVAL) < 0 ? 0 : diff;
    }

    public Log getLogByCode(Integer logCode) {
        return repository.getById(logCode);
    }

    public LogDTO getLogDTOByCode(Integer logCode) {
        LogDTO dto = new LogDTO(repository.getById(logCode));
        return dto;
    }

    public String getLogsCsvByUser(Integer userId) {
        return LogUtils.formatLogCsv(repository.getLogsByUser(userId));
    }

    public List<LogDTO> getLogsDTOByDate(Integer userId, String logDate) {
        List<Log> logs = repository.getLogDTOByUserDate(userId, logDate);
        List<LogDTO> logsDTODate = new ArrayList<>();
        logs.stream().forEach(log -> {
            logsDTODate.add(new LogDTO(log));
        });
        return logsDTODate;
    }

}
