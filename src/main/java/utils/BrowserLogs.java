package utils;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.logging.LogType;

import java.util.List;

public class BrowserLogs {

    public List getConsoleLog() {
        return Selenide.getWebDriverLogs(LogType.BROWSER);
    }

}
