package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.LocalDriverConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import lombok.Getter;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;
import static io.appium.java_client.remote.MobilePlatform.ANDROID;

public class LocalMobileDriver implements WebDriverProvider {

    private static final LocalDriverConfig config = ConfigFactory.create(LocalDriverConfig.class, System.getProperties());
    @Getter
    private static AndroidDriver driver;

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();

        options.setAutomationName(ANDROID_UIAUTOMATOR2)
                .setPlatformName(ANDROID)
                .setPlatformVersion(config.getOsVersion())
                .setDeviceName(config.getDevice())
                .setApp(getAppPath())
                .setAppPackage(config.getAppPackage());

        driver = new AndroidDriver(getAppiumServerUrl(), options);
        return driver;
    }

    public static URL getAppiumServerUrl() {
        try {
            return new URL(config.getAppiumUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private String getAppPath() {
        String appName = "com.uniqlo.my.catalogue.apk";
        String appPath = "src/test/resources/apps/" + appName;

        File app = new File(appPath);
        return app.getAbsolutePath();
    }
}