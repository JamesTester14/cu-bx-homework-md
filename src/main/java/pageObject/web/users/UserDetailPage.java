package pageObject.web.users;

import io.qameta.allure.Step;
import pageObject.web.BasePage;

import static com.codeborne.selenide.Selenide.$;

public class UserDetailPage extends BasePage {
    @Step("Get Username")
    public String crumbs(){
      return $("#firstName").getValue() + " " + $("#lastName").getValue();
    }


}
