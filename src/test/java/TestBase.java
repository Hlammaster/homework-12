import org.junit.jupiter.api.BeforeAll;
import pages.RegistrationPage;

import static com.codeborne.selenide.Configuration.browserSize;

public class TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll() {
        browserSize = "1920x1080";
    }

}
