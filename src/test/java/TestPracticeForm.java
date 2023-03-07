import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


public class TestPracticeForm extends TestBase {


    @Test
    void fillFormTest() {

        registrationPage.openPage()
                .setFirstName("Sirius")
                .setLastName("Black")
                .setEmail("cat@mail.ru")
                .setGender("Mail")
                .userNumberInput("1234567890")
                .setBirthDate("30", "July", "2020")
                .subjectsInput("Chemistry")
                .setHobbies("Music")
                .setPicture("wallpaperflare.com_wallpaper (13).jpg")
                .currentAddressInput("Izmir")
                .setState("Uttar Pradesh")
                .setCity("Agra")
                .submitClick();

        registrationPage.verifyResultsModalAppears()
                        .verifyResults()



        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Sirius"), text("Black"),
                text("cat@mail.ru"), text("1234567890"));
        $("#closeLargeModal").click();


    }


}
