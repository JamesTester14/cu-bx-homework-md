package utils;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.logging.LogType;

import java.util.List;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class BrowserLogs {

    public List getConsoleLog() {
        return Selenide.getWebDriverLogs(LogType.BROWSER);
    }

    public void getLogsJS(){
        String js =
                "var performance = window.performance || window.mozPerformance" +
                        " || window.msPerformance || window.webkitPerformance || {};" +
                        " return performance.getEntries() || {};";
        String netData = executeJavaScript(js).toString();
    }

}
