package com.kn.contactlist.exception.handler;


import com.kn.contactlist.common.CommonVariables;
import com.kn.contactlist.common.error.ErrorCodes;
import com.kn.contactlist.common.controller.ControllerError;
import com.kn.contactlist.common.controller.ControllerResponse;
import com.kn.contactlist.common.controller.ControllerResponseBuilder;
import com.kn.contactlist.common.error.ErrorMessages;
import com.kn.contactlist.exception.type.BusinessException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger log = LogManager.getLogger(GlobalExceptionHandler.class);

    private final ErrorMessages errorMessages;

    @Autowired
    public GlobalExceptionHandler(ErrorMessages errorMessages) {
        this.errorMessages = errorMessages;
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ControllerResponse<ControllerError>> handleDefaultException(Throwable e) {
        log.error("Global exception :", e);
        String errorMsg = errorMessages.getErrorMessage(ErrorCodes.ERROR_CODE_SYSTEM_RETURN_UNEXPECTED_EXCEPTION);
        ControllerError controllerError = new ControllerError(ErrorCodes.ERROR_CODE_SYSTEM_RETURN_UNEXPECTED_EXCEPTION.getValue(), errorMsg);
        return ControllerResponseBuilder.error(controllerError, CommonVariables.ControllerReturnMessages.FAIL.toString());

    }

    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<ControllerResponse<ControllerError>> handleBusinessException(BusinessException e) {
        log.error("ErrorCode: {}, Exception : {}, ExceptionDetail: {}", e.getErrorCodes(), e, e.getInnerException());

        String errorMsg = errorMessages.getErrorMessage(e.getErrorCodes());
        ControllerError restError = new ControllerError(e.getErrorCodes().getValue(), errorMsg);

        return ControllerResponseBuilder.error(restError, CommonVariables.ControllerReturnMessages.FAIL.toString());
    }
}

