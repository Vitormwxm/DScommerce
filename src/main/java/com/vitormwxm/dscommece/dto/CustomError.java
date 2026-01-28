package com.vitormwxm.dscommece.dto;

import java.time.Instant;

public class CustomError {

    private Instant timestamp;
    private Integer status;
    private String error;
    private String path;

    public CustomError(Instant timestamp,  Integer status, String path, String error) {
        this.timestamp = timestamp;
        this.path = path;
        this.error = error;
        this.status = status;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public String getPath() {
        return path;
    }

    public String getError() {
        return error;
    }

    public Integer getSatus() {
        return status;
    }
}
