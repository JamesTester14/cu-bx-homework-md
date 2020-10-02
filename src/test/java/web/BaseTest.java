package web;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static utils.Credentials.BASE_URL;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
@Execution(ExecutionMode.CONCURRENT)
public class BaseTest {

    @BeforeAll
    public static void setup(){
        System.setProperty("selenide.baseUrl", BASE_URL);
        Configuration.browserSize = "1920x1080";
        Configuration.screenshots = true;
        Configuration.fastSetValue = true;
        Configuration.timeout = 8000;
        if (System.getenv("selenide.remote") != null) {
            Configuration.driverManagerEnabled = false;
        }
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
