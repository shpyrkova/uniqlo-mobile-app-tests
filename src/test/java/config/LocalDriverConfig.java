package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:${env}.properties"})
public interface LocalDriverConfig extends Config {

    @Key("osVersion")
    String getOsVersion();

    @Key("device")
    String getDevice();

    @Key("appPackage")
    @DefaultValue("com.ohmywishes.start")
    String getAppPackage();

    @Key("appiumUrl")
    String getAppiumUrl();

}