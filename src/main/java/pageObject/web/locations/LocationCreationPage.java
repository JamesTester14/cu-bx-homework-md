package pageObject.web.locations;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import pageObject.web.BasePage;
import utils.Helper;
import utils.dataGeneration.LocationBuilder;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LocationCreationPage extends BasePage {
    public static final String crumbs = "Create";

    Helper helper = new Helper();

    public String pageUrl(){
        return getBaseUrl() + "locations/create";
    }

    @Step("Fill necessary location fields")
    public void fillNewLocation(LocationBuilder location){
        $$(".FormGenericSelect__placeholder").findBy(Condition.text("Type *")).click();
        $(".GenericModifiableTypeSelect-ListItemContainer").shouldHave(Condition.text("DefaultLocationType")).click();
        $("input[name='locationName']").sendKeys(location.getName());
        $$(".genericFormFooter-SaveButton-enabled").get(0).click();
        helper.selectOptionFromDropdown(location.getCountry(), "Country");
        helper.selectOptionFromDropdown("-", "State");
        helper.selectOptionFromDropdown(location.getCity(), "City");
        $("input[name='locationAddress']").sendKeys(location.getAddress());
    }

    @Step("Save new Location data")
    public void saveNewLocation(){
        $$(".genericFormFooter-SaveButton-enabled").get(1).click();
        $(".genericMasterForm-Create").click();
        $(".MuiSnackbarContent-message").shouldBe(Condition.visible);
    }
}
