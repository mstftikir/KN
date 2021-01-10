package com.kn.contactlist.common.error;

import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.Map;

@Component
public class ErrorMessages {

    private final Map<ErrorCodes, String> errorMessageMap = new EnumMap<>(ErrorCodes.class);

    public ErrorMessages() {
        errorMessageMap.put(ErrorCodes.ERROR_CODE_SYSTEM_RETURN_UNEXPECTED_EXCEPTION, "System error.");

        errorMessageMap.put(ErrorCodes.ERROR_CODE_CONTACT_NOT_FOUND_EXCEPTION, "Contacts not found.");

        errorMessageMap.put(ErrorCodes.ERROR_CODE_CONTACT_READ_FROM_FILE_EXCEPTION, "Error while reading contacts from file.");
    }

    public String getErrorMessage(ErrorCodes errorCodes) {
        return errorMessageMap.get(errorCodes);
    }
}
