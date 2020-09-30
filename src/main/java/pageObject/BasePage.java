package pageObject;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
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

    @Step("Login as Admin")
    public void logInAsAdmin() {
        $("input[name='email']").sendKeys(ADMIN_EMAIL);
        $("input[name='password']").sendKeys(ADMIN_PASSWORD);
        $(".LoginFormComponent-LoginButton").click();
        $(".mainLayoutheader-usersNameInitialsLogo").waitUntil(Condition.visible, 5000);
    }

}
