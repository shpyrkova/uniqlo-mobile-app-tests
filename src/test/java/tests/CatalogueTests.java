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
    @DisplayName("Поиск товара в каталоге по названию")
    void productSearchTest() {
        steps.skipOnboarding();
        steps.searchProductWithText("crew neck long sleeve stripe toddler");
        steps.tapOnProductName("CREW NECK T-SHIRT | LONG SLEEVE | STRIPE");
        step("Проверить, что открыт экран выбранного товара", () ->
            $(id("com.uniqlo.my.catalogue:id/textViewProductId")).shouldHave(text("470826"), Duration.ofSeconds(10))
        );
    }

    @Test
    @DisplayName("Добавление товара в вишлист")
    void addProductToWishlistTest() {
        steps.skipOnboarding();
        steps.searchProductWithText("round shoulder bag quilted");
        steps.tapOnProductName("ROUND SHOULDER BAG | QUILTED");
        step("Добавить товар в вишлист", () ->
            $(androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
                    ".scrollIntoView(new UiSelector().resourceId(\"com.uniqlo.my.catalogue:id/favorite_button\"))")).click()
        );
        step("Вернуться на предыдущий экран", () ->
            env.getDriver().pressKey(new KeyEvent(AndroidKey.BACK))
        );
        step("Перейти в меню Wish list", () ->
            $(id("com.uniqlo.my.catalogue:id/navigation_favorite")).click()
        );
        step("Отклонить получение уведомлений", () ->
            $(id("com.uniqlo.my.catalogue:id/dont_receive_button")).click()
        );
        step("Проверить, что в вишлисте есть добавленный товар", () ->
            $(id("com.uniqlo.my.catalogue:id/name_text")).shouldHave(text("Round Shoulder Bag | Quilted"), Duration.ofSeconds(10))
        );
    }

    @Test
    @DisplayName("Просмотр экрана отзывов о товаре")
    void reviewScreenTest() {
        steps.skipOnboarding();
        steps.searchProductWithText("Ultra Stretch DRY-EX Full-Zip Hoodie Print");
        steps.tapOnProductName("ULTRA STRETCH DRY-EX FULL-ZIP HOODIE | PRINT");
        step("Тап на количество отзывов на товар", () ->
                $(id("com.uniqlo.my.catalogue:id/reviewNumText")).click()
        );
        step("Проверить, что открыт экран отзывов о товаре", () -> {
            $(androidUIAutomator("new UiSelector().text(\"RATINGS\")")).shouldBe(visible, Duration.ofSeconds(10));
            $(androidUIAutomator("new UiSelector().text(\"HOW IT FITS\")")).shouldBe(visible, Duration.ofSeconds(10));
        });
    }

}
