package helpers;

import drivers.BrowserstackDriver;
import drivers.LocalMobileDriver;
import io.appium.java_client.android.AndroidDriver;

public class MobileEnvironment {

    public boolean isBrowserstack() {
        String deviceHost = System.getProperty("deviceHost");

        if (deviceHost == null || deviceHost.equals("browserstack")) {
            return true;
        }
        return false;
    }

    public AndroidDriver getDriver() {
        String deviceHost = System.getProperty("deviceHost");

        if (deviceHost == null || deviceHost.equals("browserstack")) {
            return BrowserstackDriver.getDriver();
        }
        return LocalMobileDriver.getDriver();
    }
}