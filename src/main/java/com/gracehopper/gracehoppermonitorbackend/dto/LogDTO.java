package com.gracehopper.gracehoppermonitorbackend.dto;

import com.gracehopper.gracehoppermonitorbackend.model.Log;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class LogDTO implements Serializable {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private Integer logCode;
    private String content;
    private String logDate;
    private Integer userId;

    public LogDTO(Log log) {
        this.logCode = log.getLogCode();
        this.content = log.getContent();
        this.logDate = log.getLogDate().format(formatter);
        this.userId = log.getUserId().getUserId();
    }
}
