package org.springboardfoundation.dbservice.web;

public class ApiConstants {

    // request params
    public static final String MOBILE_NUMBER_PARAM = "{mobileNumber}";
    public static final String USERID_PARAM = "{userId}";
    public static final String OTPID_PARAM = "{otpId}";

    // api paths
    public static final String ID_PATH = "id";
    public static final String BASE_PATH = "/api/v1/ds";
    public static final String USER_PATH_SEGMENT = "/user";
    public static final String USER_PATH = BASE_PATH + "/" + USER_PATH_SEGMENT;
    public static final String NEED_PATH_SEGMENT = "/need";
    public static final String NEED_PATH = BASE_PATH + "/" + NEED_PATH_SEGMENT;
    public static final String OTP_PATH_SEGMENT = "/otp";
    public static final String OTP_PATH = BASE_PATH + "/" + OTP_PATH_SEGMENT;

    private ApiConstants() {
        throw new UnsupportedOperationException("Cannot instantiate a constants class");
    }
}