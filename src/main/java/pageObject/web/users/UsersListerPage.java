package pageObject.web.users;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class UsersListerPage extends BaseUsersPage {
    public Asserts asserts = new Asserts();

    public String pageUrl() {
        return getBaseUrl() + "users";
    }

    @Step("Go to operators listing")
    public void visitOperatorsLister() {
        $$(".menuItem-subMenuButton").findBy(Condition.text("Operators")).click();
        $(".EntitiesComponentHeader-EntitiesNumberContainer").shouldHave(Condition.text("Operators"));
    }


    public class Asserts {
        @Step("Check user is created")
        public void checkUserSuccessCreation() {
            $(".MuiSnackbarContent-message").shouldHave(Condition.text("Success"));
        }
    }

}
