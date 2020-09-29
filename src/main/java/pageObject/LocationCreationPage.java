package pageObject;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static utils.dataGeneration.Randomizer.randomizeString;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import utils.dataGeneration.LocationBuilder;

public class LocationCreationPage extends BasePage{

    public String pageUrl(){
        return getBaseUrl() + "locations/create";
    }

    @Step("Fill necessary location fields")
    public void fillNewLocation(LocationBuilder location){
//        $$(".FormGenericSelect__control").get(0).click();
        $$(".FormGenericSelect__placeholder").findBy(Condition.text("Type *")).click();
        $(".GenericModifiableTypeSelect-ListItemContainer").shouldHave(Condition.text("DefaultLocationType")).click();
        $("input[name='locationName']").sendKeys(location.getName());
        $$(".genericFormFooter-SaveButton-enabled").get(0).click();
        $$(".FormGenericSelect__placeholder").findBy(Condition.text("Country")).click();
        $(".FormGenericSelect__menu-list").shouldBe(Condition.visible);
        $$(".FormGenericSelect__option").findBy(Condition.text(location.getCountry())).click();
        $$(".FormGenericSelect__placeholder").findBy(Condition.text("State")).click();
        $$("#react-select-4-option-0").findBy(Condition.text("-")).click();
        $$(".FormGenericSelect__placeholder").findBy(Condition.text("City")).click();
        $$(".FormGenericSelect__option").findBy(Condition.text(location.getCity())).click();
        $("input[name='locationAddress']").sendKeys(location.getAddress());
        $$(".genericFormFooter-SaveButton-enabled").get(1).click();
        $(".genericMasterForm-Create").click();
        $(".MuiSnackbarContent-message").shouldBe(Condition.visible);
    }
}
