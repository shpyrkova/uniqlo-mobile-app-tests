package tests;

import helpers.MobileEnvironment;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.androidUIAutomator;
import static io.appium.java_client.AppiumBy.id;

public class CommonSteps {

    MobileEnvironment env = new MobileEnvironment();

    @Step("Пропустить онбординг")
    public void skipOnboarding() {
        $(id("com.uniqlo.my.catalogue:id/buttonSkip")).click();
    }

    @Step("В поле поиска товаров ввести {0}")
    public void searchProductWithText(String text) {
        $(id("com.uniqlo.my.catalogue:id/navigation_search")).click();
        $(id("com.uniqlo.my.catalogue:id/search_edit_text")).click();
        $(id("com.uniqlo.my.catalogue:id/search_edit_text")).sendKeys(text);
        env.getDriver().pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    @Step("Тап на найденный товар {0}")
    public void tapOnProductName(String text) {
        $(androidUIAutomator("new UiSelector().text(\"" + text + "\")")).click();
    }

}
