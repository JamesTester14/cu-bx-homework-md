package pageObject.users;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import pageObject.BasePage;
import utils.DropdownHelper;
import utils.dataGeneration.UserBuilder;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BaseUsersPage extends BasePage {

    DropdownHelper dropdownHelper = new DropdownHelper();

    @Step("Click on 'Create New'")
    public void createNewUser(UserBuilder user) {
        $(".EntitiesComponentHeader-CreateButton").click();
//        dropdownHelper.selectOptionFromDropdown("Mr", "Title");

        $$(".FormGenericTitleSelect__placeholder").findBy(Condition.text("Title")).click();
        $$(".FormGenericTitleSelect__option").findBy(Condition.text("Mr")).click();

        $("input[name='firstName']").sendKeys(user.getFname());
        $("input[name='lastName']").sendKeys(user.getLname());
        $("input[name='email']").sendKeys(user.getEmail());
        $("input[name='phone']").sendKeys(user.getPhone());
        dropdownHelper.selectOptionFromDropdown(user.getCompany(), "Company");

        $$(".genericFormFooter-SaveButton-enabled").get(0).click();
        $$("input[type='checkbox']").get(4).click();
        $(".MuiInputBase-inputSelect.MuiFilledInput-inputSelect").click();
        $$("ul li.MuiListItem-button").get(0).click();
        $("ul li.MuiListItem-button").sendKeys(Keys.ESCAPE);
        $$(".genericFormFooter-SaveButton-enabled").get(1).click();
        $("input[name='height']").sendKeys(user.getHeight());
        $("input[name='weight']").sendKeys(user.getWeight());
        $(".FormGenericGenderSelect__placeholder").shouldHave(Condition.text("Select Gender")).click();
        $$(".FormGenericGenderSelect__option").findBy(Condition.text(user.getGender())).click();
        $("input[name='age']").sendKeys(user.getAge());
        $$(".genericFormFooter-SaveButton-enabled").get(2).click();
        $(".genericMasterForm-Create").click();
    }


}
