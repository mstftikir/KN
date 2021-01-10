package com.kn.contactlist.common.controller;

import java.io.Serializable;

public class ControllerResponse<T> implements Serializable {

    private transient T data;

    private ControllerResponseHeader result;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ControllerResponseHeader getResult() {
        return result;
    }

    public void setResult(ControllerResponseHeader status) {
        this.result = status;
    }
}

