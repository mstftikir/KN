package com.kn.contactlist.exception.type;


import com.kn.contactlist.common.error.ErrorCodes;

public class BusinessException extends Exception {

    private final ErrorCodes errorCodes;
    private final Exception ex;

    public BusinessException(ErrorCodes errorCodes) {
        super();
        this.errorCodes = errorCodes;
        this.ex = null;
    }

    public BusinessException(Exception e, ErrorCodes errorCodes) {
        super();
        this.errorCodes = errorCodes;
        this.ex = e;
    }

    public ErrorCodes getErrorCodes() {
        return errorCodes;
    }

    public Exception getInnerException() {
        return ex;
    }
}
