package com.gracehopper.gracehoppermonitorbackend.model;

import com.gracehopper.gracehoppermonitorbackend.enums.UserStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class InactiveResponse {

    private LocalDateTime lastLog;
    private Long minutesInactive;
    private UserStatus status;
}
