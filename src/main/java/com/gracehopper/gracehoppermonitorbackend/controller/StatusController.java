package com.gracehopper.gracehoppermonitorbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

    @GetMapping(path = "/")
    public String getAppStatus() {
        return "online";
    }
}
