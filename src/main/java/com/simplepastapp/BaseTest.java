package com.simplepastapp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.AndroidMobileCapabilityType.*;
import static io.appium.java_client.remote.MobileCapabilityType.*;

public abstract class BaseTest {

    public AppiumDriver<MobileElement> driver;

    @BeforeTest()
    public void beforeTest() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(PLATFORM_NAME, MobilePlatform.ANDROID);
        capabilities.setCapability(DEVICE_NAME, "Emulador Android");
        capabilities.setCapability(APP_PACKAGE, "com.simplepastapp");
        capabilities.setCapability(APP_ACTIVITY, "com.simplepastapp.MainActivity");
        capabilities.setCapability(AUTOMATION_NAME, "uiautomator2");

        driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
    }

    @AfterTest()
    public void afterTest() {
        driver.quit();
    }
}
