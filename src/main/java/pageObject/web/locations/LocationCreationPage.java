package pageObject.web.locations;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import pageObject.web.BasePage;
import utils.Helper;
import utils.dataGeneration.LocationBuilder;

import static com.codeborne.selenide.Selenide.*;

public class LocationCreationPage extends BasePage {

    Helper helper = new Helper();

    public String pageUrl(){
        return getBaseUrl() + "locations/create";
    }

    @Step("Fill necessary location fields")
    public void fillNewLocation(LocationBuilder location){
        $("input[name='locationName']").sendKeys(location.getName());
        sleep(1000);
        $$(".FormGenericSelect__placeholder").findBy(Condition.text("Type *")).click();
        $(".GenericModifiableTypeSelect-ListItemContainer").shouldHave(Condition.text("DefaultLocationType")).click();
        $("input[name='locationDescription']").sendKeys(location.getDescription());
        $$(".genericFormContainer-HeadLine").findBy(Condition.text("Address")).click();
        helper.selectOptionFromDropdown(location.getCountry(), "Country");
        helper.selectOptionFromDropdown("-", "State");
        helper.selectOptionFromDropdown(location.getCity(), "City");
        $("input[name='locationAddress']").sendKeys(location.getAddress());
    }

    @Step("Save new Location data")
    public void saveNewLocation(){
        $(".genericMasterForm-Create").click();
        $(".MuiSnackbarContent-message").shouldBe(Condition.visible);
    }
}
