package com.kn.contactlist.common.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public class ControllerResponseBuilder {

    private ControllerResponseBuilder() {
    }

    public static <T> ResponseEntity<ControllerResponse<T>> success(T data, String headerMessage) {
        ControllerResponse<T> controllerResponse = new ControllerResponse<>();

        controllerResponse.setData(data);
        ControllerResponseHeader status = new ControllerResponseHeader();
        status.setMessage(headerMessage);
        controllerResponse.setResult(status);

        return buildResponse(HttpStatus.OK, controllerResponse);
    }

    public static <T> ResponseEntity<ControllerResponse<T>> error(T data, String headerMessage) {
        ControllerResponse<T> controllerResponse = new ControllerResponse<>();
        controllerResponse.setData(data);

        ControllerResponseHeader status = new ControllerResponseHeader();
        status.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        status.setMessage(headerMessage);
        controllerResponse.setResult(status);
        return buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, controllerResponse);
    }

    private static <T> ResponseEntity<ControllerResponse<T>> buildResponse(HttpStatus httpStatus, ControllerResponse<T> controllerResponse) {
        String uuid = UUID.randomUUID().toString();
        controllerResponse.getResult().setGuid(uuid);
        return new ResponseEntity<>(controllerResponse, httpStatus);
    }
}
