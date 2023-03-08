import org.junit.jupiter.api.Test;


public class TestPracticeForm extends TestBase {


    @Test
    void fillFormTest() {

        registrationPage.openPage()
                .removebannner()
                .setFirstName("Sirius")
                .setLastName("Black")
                .setEmail("cat@mail.ru")
                .setGender("Male")
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
                .verifyResults("Student Name", "Sirius Black")
                .verifyResults("Student Email", "cat@mail.ru")
                .verifyResults("Gender", "Male")
                .verifyResults("Mobile", "1234567890")
                .verifyResults("Date of Birth", "30 July,2020")
                .verifyResults("Subjects", "Chemistry")
                .verifyResults("Hobbies", "Music")
                .verifyResults("Address", "Izmir")
                .verifyResults("State and City", "Uttar Pradesh Agra");
        registrationPage.closeButtonClick();

    }


}
