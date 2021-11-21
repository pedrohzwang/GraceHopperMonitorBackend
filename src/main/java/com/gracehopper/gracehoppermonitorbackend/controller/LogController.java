package com.gracehopper.gracehoppermonitorbackend.controller;

import com.gracehopper.gracehoppermonitorbackend.model.Log;
import com.gracehopper.gracehoppermonitorbackend.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/log")
public class LogController {

    @Autowired
    LogService logService;

    @PostMapping
    public ResponseEntity<Log> addLog(@RequestBody Log log) {
        System.out.println(log.toString());
        return ResponseEntity.ok(logService.saveLog(log));
    }

    @GetMapping
    public String status() {
        return "Online";
    }
}
