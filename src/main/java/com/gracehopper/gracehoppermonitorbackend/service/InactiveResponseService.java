package com.gracehopper.gracehoppermonitorbackend.service;

import com.gracehopper.gracehoppermonitorbackend.model.InactiveResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InactiveResponseService {

    @Autowired
    LogService logService;

    @Autowired
    UserService userService;

    public InactiveResponse generateResponse(Integer userId) {
        InactiveResponse response = new InactiveResponse();
        response.setLastLog(logService.getLastLogByUser(userService.getUserById(userId)).getLogDate());
        response.setMinutesInactive(logService.getInactiveTimeByUser(userId));
        response.setStatus(userService.getUserStatus(userId));
        return response;
    }
}
