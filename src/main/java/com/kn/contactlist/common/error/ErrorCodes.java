package com.kn.contactlist.common.error;

public enum ErrorCodes {

    /***********SYSTEM ERROR CODES - start with 10000***********/
    ERROR_CODE_SYSTEM_RETURN_UNEXPECTED_EXCEPTION(10000),

    /***********CONTACT LIST ERROR CODES - start with 20000***********/
    ERROR_CODE_CONTACT_NOT_FOUND_EXCEPTION(20000),
    ERROR_CODE_CONTACT_READ_FROM_FILE_EXCEPTION(20001);

    private final int value;

    ErrorCodes(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
