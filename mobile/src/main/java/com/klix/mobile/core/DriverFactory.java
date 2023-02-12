package com.klix.mobile.core;

import io.appium.java_client.android.AndroidDriver;

public interface DriverFactory {

    AndroidDriver newAppiumInstance();

    String name();
}