package helpers;

import drivers.BrowserstackDriver;
import drivers.LocalMobileDriver;
import io.appium.java_client.android.AndroidDriver;

public class MobileEnvironment {

    public boolean isBrowserstack() {
        String env = System.getProperty("env");

        return env == null || env.equals("browserstack");
    }

    public AndroidDriver getDriver() {
        String env = System.getProperty("env");

        if (env == null || env.equals("browserstack")) {
            return BrowserstackDriver.getDriver();
        }
        return LocalMobileDriver.getDriver();
    }
}