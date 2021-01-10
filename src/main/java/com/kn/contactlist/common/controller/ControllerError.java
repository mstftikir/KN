package com.kn.contactlist.common.controller;

import java.io.Serializable;

public class ControllerError implements Serializable {

    private static final long serialVersionUID = 311402880585374645L;

    private int reasonCode;
    private String messageText;

    public ControllerError(int reasonCode, String messageText) {
        this.reasonCode = reasonCode;
        this.messageText = messageText;
    }

    public int getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(int reasonCode) {
        this.reasonCode = reasonCode;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
}

