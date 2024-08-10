package tests;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.androidUIAutomator;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

@Epic("Тесты на мобильное приложение Uniqlo (Android)")
@DisplayName("Каталог товаров")
public class CatalogueTests extends TestBase {

    @Test
    @DisplayName("Поиск продукта в каталоге по названию")
    void productSearchTest() {
        step("Авторизоваться в приложении", () -> {
            $(id("com.uniqlo.my.catalogue:id/buttonSkip")).click();
            $(id("com.uniqlo.my.catalogue:id/navigation_search")).click();
            $(id("com.uniqlo.my.catalogue:id/search_edit_text")).click();
            $(id("com.uniqlo.my.catalogue:id/search_edit_text")).sendKeys("crew neck long sleeve stripe toddler");
            env.getDriver().pressKey(new KeyEvent(AndroidKey.ENTER));
            $(androidUIAutomator("new UiSelector().text(\"CREW NECK T-SHIRT | LONG SLEEVE | STRIPE\")")).click();
        });

        step("Проверить, что открыта страница выбранного продукта", () -> {
            $(id("com.uniqlo.my.catalogue:id/textViewProductId")).shouldHave(text("470826"), Duration.ofSeconds(10));
        });
    }

    @Test
    @DisplayName("Добавление продукта в вишлист")
    void addProductToWishlistTest() {
        step("Авторизоваться в приложении", () -> {
            $(id("com.uniqlo.my.catalogue:id/buttonSkip")).click();
            $(id("com.uniqlo.my.catalogue:id/navigation_search")).click();
            $(id("com.uniqlo.my.catalogue:id/search_edit_text")).click();
            $(id("com.uniqlo.my.catalogue:id/search_edit_text")).sendKeys("round shoulder bag quilted");
            env.getDriver().pressKey(new KeyEvent(AndroidKey.ENTER));
            $(androidUIAutomator("new UiSelector().text(\"ROUND SHOULDER BAG | QUILTED\")")).click();
            $(androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
                    ".scrollIntoView(new UiSelector().resourceId(\"com.uniqlo.my.catalogue:id/favorite_button\"))")).click();
            env.getDriver().pressKey(new KeyEvent(AndroidKey.BACK));
            $(id("com.uniqlo.my.catalogue:id/navigation_favorite")).click();
            $(id("com.uniqlo.my.catalogue:id/dont_receive_button")).click();
        });

        step("Проверить, что открыта страница выбранного продукта", () -> {
            $(id("com.uniqlo.my.catalogue:id/name_text")).shouldHave(text("Round Shoulder Bag | Quilted"), Duration.ofSeconds(10));
        });
    }

    @Test
    @DisplayName("Просмотр гайда по размерам товара")
    void faqSearchTest() {
        step("Авторизоваться в приложении", () -> {
            $(id("com.uniqlo.my.catalogue:id/buttonSkip")).click();
            $(id("com.uniqlo.my.catalogue:id/navigation_search")).click();
            $(id("com.uniqlo.my.catalogue:id/search_edit_text")).click();
            $(id("com.uniqlo.my.catalogue:id/search_edit_text")).sendKeys("Ultra Stretch DRY-EX Full-Zip Hoodie Print");
            env.getDriver().pressKey(new KeyEvent(AndroidKey.ENTER));
            $(androidUIAutomator("new UiSelector().text(\"ULTRA STRETCH DRY-EX FULL-ZIP HOODIE | PRINT\")")).click();
            $(id("com.uniqlo.my.catalogue:id/reviewNumText")).click();
        });

        step("Проверить, что открыта страница выбранного продукта", () -> {
            $(androidUIAutomator("new UiSelector().text(\"RATINGS\")")).shouldBe(visible, Duration.ofSeconds(10));
            $(androidUIAutomator("new UiSelector().text(\"HOW IT FITS\")")).shouldBe(visible, Duration.ofSeconds(10));
        });
    }

}
