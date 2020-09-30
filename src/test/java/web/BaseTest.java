package web;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;

import java.util.logging.Level;

import static utils.Credentials.BASE_URL;

public class BaseTest {

    @BeforeAll
    public static void setup(){
        LoggingPreferences logs = new LoggingPreferences();
        logs.enable(LogType.BROWSER, Level.SEVERE);
        Configuration.browserCapabilities.setCapability(CapabilityType.LOGGING_PREFS, logs);
        System.setProperty("selenide.baseUrl", BASE_URL);
        Configuration.browserSize = "1920x1080";
        Configuration.screenshots = true;
        Configuration.fastSetValue = true;
        Configuration.timeout = 8000;
    }

    @AfterAll
    public static void removeAllure() {
        SelenideLogger.removeListener("allure");
    }

    @BeforeEach
    public void addAllure() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
}
