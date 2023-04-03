package tests;

import com.codeborne.selenide.Configuration;
import helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Configuration.browserSize;

public class TestBase {


    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = System.getProperty("url");
        Configuration.remote = "https://user1:1234@" + System.getProperty("selenoidurl");
        Configuration.browserSize = System.getProperty("browser_size");
        Configuration.browser = System.getProperty("browser");
        Configuration.browserVersion = System.getProperty("version");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

    }
    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

}
