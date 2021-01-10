package com.kn.contactlist.common;

public class CommonVariables {

    private CommonVariables() {

    }

    public static final String INDEX = "index";

    public static final String SERVICE_USER_ID = "10000";

    public enum ControllerReturnMessages {
        SUCCESS("Success"),
        FAIL("Fail");

        private final String stringValue;

        ControllerReturnMessages(String stringValue) {

            this.stringValue = stringValue;
        }

        @Override
        public String toString() {
            return this.stringValue;
        }
    }
}
