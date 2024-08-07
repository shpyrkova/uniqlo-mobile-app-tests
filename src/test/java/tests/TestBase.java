package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.MobileDriverProvider;
import helpers.Attachments;
import helpers.MobileEnvironment;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    MobileEnvironment env = new MobileEnvironment();

    @BeforeAll
    static void beforeAll() {
        MobileDriverProvider mobileDriverProvider = new MobileDriverProvider();
        mobileDriverProvider.setMobileConfig();
        Configuration.timeout = 4000;
        Configuration.pollingInterval = 200;
        Configuration.browserSize = null;
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
//        steps.closeOnboarding();
    }

    @AfterEach
    void addAttachments() {
        Attachments.pageSource();
        closeWebDriver();
//        if (env.isBrowserstack()) {
//            String sessionId = Selenide.sessionId().toString();
//            Attachments.addVideo();
        }
    }
