package com.klix.mobile.pages.login;

//TODO -- elements will be deleted after language selecting test in login screen will be refactored
public class AppLoginPageElements {

    public static final String CLIENT_ID_INPUT = ".EditText[@resource-id='apk.drivers:id/text_client_id']";
    public static final String CLIENT_USERNAME_INPUT = ".EditText[@resource-id='apk.drivers:id/text_login']";
    public static final String CLIENT_PASSWORD_INPUT = ".EditText[@resource-id='apk.drivers:id/text_password']";
    public static final String SIGN_IN_BUTTON = ".Button[@resource-id='apk.drivers:id/sign_in_button']";
    public static final String LOCATION_BUTTON = ".TextView[@resource-id='apk.drivers:id/current_locale']";
    public static final String LOGIN_SIGN_IN_TITLE = ".TextView[@resource-id='apk.drivers:id/login_sign_in_title']";
    public static final String LOGIN_SIGN_IN_SUBTITLE = ".TextView[@resource-id='apk" +
            ".drivers:id/login_sign_in_subtitle']";
    public static final String ALLOW_LOCATION_PERMISSION = ".Button[@resource-id='com.android" +
            ".packageinstaller:id/permission_allow_button']";
    public static final String DENY_LOCATION_PERMISSION = ".Button[@resource-id='com.android" +
            ".packageinstaller:id/permission_deny_button']";
}