package tests;

import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Configuration.browserSize;

public class TestBase {


    @BeforeAll
    static void beforeAll() {
        browserSize = "1920x1080";
    }

}
