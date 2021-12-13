package com.gracehopper.gracehoppermonitorbackend.controller;

import com.gracehopper.gracehoppermonitorbackend.model.Log;
import com.gracehopper.gracehoppermonitorbackend.model.User;
import com.gracehopper.gracehoppermonitorbackend.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;

@RestController
@RequestMapping("/api/log")
public class LogController {

    @Autowired
    LogService logService;

    @PostMapping
    public ResponseEntity<Log> addLog(@RequestBody Log log) {
        return ResponseEntity.ok(logService.saveLog(log));
    }

    @GetMapping("/export/{userId}")
    public ResponseEntity getLogFileCSV(@PathVariable Integer userId) {
        return ResponseEntity.ok(logService.getLogsCsvByUser(userId));
    }

}
