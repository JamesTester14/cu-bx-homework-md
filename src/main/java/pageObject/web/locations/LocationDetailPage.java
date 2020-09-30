package pageObject.web.locations;

import static com.codeborne.selenide.Selenide.$;

public class LocationDetailPage {
    public String crumbs(){
        return $("input[name='locationName']").getValue();
    }

}
