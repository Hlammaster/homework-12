package tests;

import com.github.javafaker.Faker;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static tests.TestData.*;
import static utils.RandomUtils.getRandomItemFromArray;


public class TestPracticeForm extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker();

    @Test
    @Feature("Форма Регистрации")
    @Story("Заполение формы регистрации")
    @DisplayName("Проверка результата вывода значений формы регистрации 'dataqa'")
    @Owner("Evgenii Goncharov")
    @Tag("dataqa")
    void fillFormTest() {
        String firstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                userEmail = faker.internet().emailAddress(),
                gender = getRandomItemFromArray(TestData.gender),
                userNumber = 8 + faker.phoneNumber().subscriberNumber(9),
                dayOfBirth = String.format("%02d", faker.number().numberBetween(1, 28)),
                monthOfBirth = getRandomItemFromArray(months),
                yearOfBirth = String.valueOf(faker.number().numberBetween(1950, 2005)),
                subject = getRandomItemFromArray(subjects),
                hobbies = getRandomItemFromArray(hobbiess),
                pictureName = "666.png",
                currentAddress = faker.address().streetAddress(),
                state = "NCR" ,
                cities = getRandomItemFromArray(TestData.cities);


        registrationPage.openPage()
                .removeBannner()
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
                .verifyResults("Student Name", firstName + " " + lastName)
                .verifyResults("Student Email", userEmail)
                .verifyResults("Gender", gender)
                .verifyResults("Mobile", userNumber)
                .verifyResults("Date of Birth",  dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .verifyResults("Subjects", subject)
                .verifyResults("Hobbies", hobbies)
                .verifyResults("Address",currentAddress)
                .verifyResults("State and City", state + " " + cities);
        registrationPage.closeButtonClick();

    }


}
