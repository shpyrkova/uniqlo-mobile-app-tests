package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:browserstack.properties"})
public interface BrowserstackConfig extends Config {
    @Key("user")
    String getUser();

    @Key("key")
    String getKey();

    @Key("remoteUrl")
    String getRemoteUrl();

    @Key("app")
    String getApp();

    @Key("device")
    @DefaultValue("Samsung Galaxy S23 Ultra")
    String getDevice();

    @Key("osVersion")
    @DefaultValue("13.0")
    String getOsVersion();

    @Key("project")
    @DefaultValue("Ohmywishes Project")
    String getProject();

    @Key("build")
    @DefaultValue("browserstack-build-1")
    String getBuild();

    @Key("name")
    @DefaultValue("Ohmywishes app tests")
    String getName();
}