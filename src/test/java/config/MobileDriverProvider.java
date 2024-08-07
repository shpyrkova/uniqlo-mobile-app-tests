package config;

import com.codeborne.selenide.Configuration;
import drivers.BrowserstackDriver;
import drivers.LocalMobileDriver;
import helpers.MobileEnvironment;

public class MobileDriverProvider {

    public void setMobileConfig() {
        MobileEnvironment env = new MobileEnvironment();
        Configuration.browserSize = null;
        Configuration.timeout = 30000;
        if (env.isBrowserstack()) {
            Configuration.browser = BrowserstackDriver.class.getName();
        } else {
            Configuration.browser = LocalMobileDriver.class.getName();
        }
    }
}