package com.gracehopper.gracehoppermonitorbackend.enums;

public enum UserStatus {
    ACTIVE(1),
    INACTIVE(2);

    private Integer code;

    UserStatus(Integer code) {
        this.code = code;
    }
}
