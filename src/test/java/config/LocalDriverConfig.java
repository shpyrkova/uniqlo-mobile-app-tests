package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:${deviceHost}.properties"})
public interface LocalDriverConfig extends Config {

    @Key("osVersion")
    String getOsVersion();

    @Key("device")
    String getDevice();

    @Key("appPackage")
    @DefaultValue("com.ohmywishes.start")
    String getAppPackage();

    @Key("appActivity")
        @DefaultValue("com.ohmywishes.start.pages.SingleActivity")
    String getAppActivity();

    @Key("appiumUrl")
    @DefaultValue("http://127.0.0.1:4723/")
    String getAppiumUrl();

}