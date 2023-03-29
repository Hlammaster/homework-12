package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Configuration.browserSize;

public class TestBase {


    @BeforeAll
    static void beforeAll() {
        browserSize = "1920x1080";
    }
    Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

}
