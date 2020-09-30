package pageObject.web.devices;

import pageObject.web.BasePage;

import static com.codeborne.selenide.Selenide.$;

public class DevicesListerPage extends BasePage {
    public String crumbs(){
        return $("input[name='deviceName']").getValue();
    }

    public String pageUrl(){
        return getBaseUrl() + "devices";
    }
}
