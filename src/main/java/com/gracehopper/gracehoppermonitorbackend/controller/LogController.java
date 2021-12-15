package com.gracehopper.gracehoppermonitorbackend.controller;

import com.gracehopper.gracehoppermonitorbackend.dto.LogDTO;
import com.gracehopper.gracehoppermonitorbackend.model.InactiveResponse;
import com.gracehopper.gracehoppermonitorbackend.model.Log;
import com.gracehopper.gracehoppermonitorbackend.service.InactiveResponseService;
import com.gracehopper.gracehoppermonitorbackend.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/log")
public class LogController {

    @Autowired
    LogService logService;

    @Autowired
    InactiveResponseService responseService;

    @PostMapping
    public ResponseEntity<Log> addLog(@RequestBody Log log) {
        return ResponseEntity.ok(logService.saveLog(log));
    }

    @GetMapping("/{userId}/export")
    public ResponseEntity getLogFileCSV(@PathVariable Integer userId) {
        return ResponseEntity.ok(logService.getLogsCsvByUser(userId));
    }

    @GetMapping("/inactiveTime/{userId}")
    public ResponseEntity<InactiveResponse> getUserInactiveTime(@PathVariable Integer userId) {
        return ResponseEntity.ok(responseService.generateResponse(userId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<LogDTO>> getUserLogs(@PathVariable Integer userId) {
        return ResponseEntity.ok(logService.getLogsByUser(userId));
    }

    @GetMapping("/user/{userId}/{logDate}")
    public ResponseEntity<List<LogDTO>> getUserLogsByDate(@PathVariable Integer userId, @PathVariable String logDate) {
        return ResponseEntity.ok(logService.getLogsDTOByDate(userId, logDate));
    }

    @GetMapping("/user/{userId}/{initialDate}/{finalDate}")
    public ResponseEntity<List<LogDTO>> getUserLogsBetweenDate(@PathVariable Integer userId, @PathVariable String initialDate, @PathVariable String finalDate) {
        return ResponseEntity.ok(logService.getLogsDTOBetweenDate(userId, initialDate, finalDate));
    }

    @GetMapping("/{logCode}")
    public ResponseEntity<LogDTO> getLogById(@PathVariable Integer logCode) {
        return ResponseEntity.ok(logService.getLogDTOByCode(logCode));
    }

}
