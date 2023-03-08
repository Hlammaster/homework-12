package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static tests.TestData.*;
import static utils.RandomUtils.getRandomItemFromArray;


public class TestPracticeForm extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker();

    @Test
    void fillFormTest() {
        String firstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                userEmail = faker.internet().emailAddress(),
                gender = getRandomItemFromArray(gender),
                userNumber = 8 + faker.phoneNumber().subscriberNumber(9),
                dayOfBirth = String.format("%02d", faker.number().numberBetween(1, 28)),
                monthOfBirth = getRandomItemFromArray(months),
                yearOfBirth = String.valueOf(faker.number().numberBetween(1950, 2005)),
                subject = getRandomItemFromArray(subjects),
                hobbies = getRandomItemFromArray(hobbiess),
                pictureName = "wallpaperflare.com_wallpaper (13).jpg",
                currentAddress = faker.address().streetAddress(),
                state = getRandomItemFromArray(states),
                cities = getRandomItemFromArray(cities);


        registrationPage.openPage()
                .removebannner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(gender)
                .userNumberInput(userNumber)
                .setBirthDate(dayOfBirth, monthOfBirth, yearOfBirth)
                .subjectsInput(subject)
                .setHobbies(hobbies)
                .setPicture(pictureName)
                .currentAddressInput(currentAddress)
                .setState(state)
                .setCity(cities)
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
