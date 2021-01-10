package com.kn.contactlist.common.controller;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

public class ControllerResponseHeader implements Serializable {
    private static final long serialVersionUID = 1L;

    private String message;

    private int statusCode;

    private String guid;

    public ControllerResponseHeader() {
        statusCode = HttpStatus.OK.value();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }


}