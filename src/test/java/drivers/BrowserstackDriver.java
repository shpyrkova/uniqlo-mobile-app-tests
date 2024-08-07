package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.BrowserstackConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import lombok.Getter;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

    private final BrowserstackConfig config = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());
    @Getter
    private static AndroidDriver driver;

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setCapability("appium:app", config.getApp());
        options.setCapability("appium:deviceName", config.getDevice());

        try {
            driver = new AndroidDriver(new URL(String.format("https://%s:%s@hub.browserstack.com/wd/hub", config.getUser(), config.getKey())), options);
            return driver;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }
}