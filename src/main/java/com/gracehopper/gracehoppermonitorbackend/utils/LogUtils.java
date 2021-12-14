package com.gracehopper.gracehoppermonitorbackend.utils;

import com.gracehopper.gracehoppermonitorbackend.model.Log;

import java.util.List;

public class LogUtils {

    public static String formatLogCsv(List<Log> logs) {
        StringBuilder content = new StringBuilder();

        logs.stream().forEach(log -> content.append(log.getLogCode()).append(";")
                .append(log.getContent()).append(";")
                .append(log.getLogDate()).append(";")
                .append(log.getUserId().getUserId()).append(";"));

        return content.toString();
    }

    public static String logFileNameByDate() {
        return null;
    }

    public static String logFileNameByUser() {
        return null;
    }

}
