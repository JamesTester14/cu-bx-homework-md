package pageObject;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LocationsListerPage extends BasePage{
    public Asserts asserts = new Asserts();

    public String pageUrl(){
        return getBaseUrl() + "locations";
    }

    @Step("Add new location")
    public void addNewLocation(){
        $(".EntitiesComponentHeader-CreateButton").click();
    }

    @Step("Get current Location records amount")
    public int getLocationsAmount(){
        String stringBeforeAmount = $(".EntitiesComponentHeader-EntityNumber").getText().replaceAll("[^0-9]", "");
        return Integer.parseInt(stringBeforeAmount);
    }

    @Step("Search for location")
    public void searchForLocation(String name) {
        $(".GenericSearch-Magnifying-GlassIcon").click();
        $(".MuiInput-input").sendKeys(name);
    }

    public class Asserts{

        @Step("Check single record on search")
        public void checkSingleLocationRecordAppears(String name){
            $$(".rt-tbody").shouldHave(CollectionCondition.size(1));
            $("div.rt-tbody > div:nth-child(1) > div > div:nth-child(1)").shouldHave(Condition.text(name));
        }
    }
}
