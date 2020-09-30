package pageObject.locations;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import pageObject.BasePage;
import utils.DropdownHelper;
import utils.dataGeneration.LocationBuilder;

public class LocationCreationPage extends BasePage {
    DropdownHelper dropdownHelper = new DropdownHelper();

    public String pageUrl(){
        return getBaseUrl() + "locations/create";
    }

    @Step("Fill necessary location fields")
    public void fillNewLocation(LocationBuilder location){
        $$(".FormGenericSelect__placeholder").findBy(Condition.text("Type *")).click();
        $(".GenericModifiableTypeSelect-ListItemContainer").shouldHave(Condition.text("DefaultLocationType")).click();
        $("input[name='locationName']").sendKeys(location.getName());
        $$(".genericFormFooter-SaveButton-enabled").get(0).click();
        dropdownHelper.selectOptionFromDropdown(location.getCountry(), "Country");
        dropdownHelper.selectOptionFromDropdown("-", "State");
        dropdownHelper.selectOptionFromDropdown(location.getCity(), "City");
        $("input[name='locationAddress']").sendKeys(location.getAddress());
    }

    @Step("Save new Location data")
    public void saveNewLocation(){
        $$(".genericFormFooter-SaveButton-enabled").get(1).click();
        $(".genericMasterForm-Create").click();
        $(".MuiSnackbarContent-message").shouldBe(Condition.visible);
    }
}
