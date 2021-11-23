package com.gracehopper.gracehoppermonitorbackend.service;

import com.gracehopper.gracehoppermonitorbackend.model.Log;
import com.gracehopper.gracehoppermonitorbackend.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogService {

    @Autowired
    LogRepository repository;

    public Log saveLog(Log log) {
        System.out.println(log.toString());
        return repository.save(log);
    }

    public Log getLogByCode(Long logCode) {
        return repository.getById(logCode);
    }
}
