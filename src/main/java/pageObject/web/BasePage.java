package pageObject.web;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;
import static utils.Credentials.ADMIN_EMAIL;
import static utils.Credentials.ADMIN_PASSWORD;

public class BasePage {

    protected String getBaseUrl() {
        return System.getProperty("selenide.baseUrl");
    }
    public String pageUrl(){
        return getBaseUrl();
    }

    @Step("Open {url} page")
    public void openPage(String url) {
        open(url);
    }

    @Step("Open version")
    public void checkVersionIs(String version){
        $(".mainLayoutheader-logoutDropDownOptions").click();
        $$(".headerToolTipMenuItem-Wrapper").findBy(Condition.text("About")).click();
        $(".Modal-Content").shouldHave(Condition.text(version));
    }

    @Step("Login as Admin")
    public void logInAsAdmin() {
        $("input[name='email']").sendKeys(ADMIN_EMAIL);
        $("input[name='password']").sendKeys(ADMIN_PASSWORD);
        $(".LoginFormComponent-LoginButton").click();
        $(".mainLayoutheader-usersNameInitialsLogo").waitUntil(Condition.visible, 5000);
    }

    @Step
    public void logout() {
        $(".mainLayoutheader-logoutDropDownOptions").click();
        $$(".headerToolTipMenuItem-Wrapper").findBy(Condition.text("log Out")).click();
        $(".LoginFormComponent-SignInContainer").shouldBe(Condition.visible);
    }
}
