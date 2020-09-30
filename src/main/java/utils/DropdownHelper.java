package utils;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$$;

public class DropdownHelper {

    @Step("Select {option} option from {dropdown} dropdown")
    public void selectOptionFromDropdown(String option, String dropdown) {
        $$(".FormGenericSelect__placeholder").findBy(Condition.text(dropdown)).click();
        $$(".FormGenericSelect__option").findBy(Condition.text(option)).click();

    }
}
