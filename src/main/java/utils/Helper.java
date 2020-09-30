package utils;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$$;

public class Helper {

    @Step("Select {option} option from {dropdown} dropdown")
    public void selectOptionFromDropdown(String option, String dropdown) {
        $$(".FormGenericSelect__placeholder").findBy(Condition.text(dropdown)).click();
        $$(".FormGenericSelect__option").findBy(Condition.text(option)).click();
    }

    @Step("Visit first record")
    public void visitFirstRecord(){
        $$(".rt-tr-group").first().hover();
        $$(".rt-tr-group").first().find(".Table-rowHoverOptions").click();
    }
}
