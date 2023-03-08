package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            setGender = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            setHobbies = $("#hobbiesWrapper"),
            setPicture = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            setState = $("#stateCity-wrapper"),
            setCity = $("#stateCity-wrapper"),
            submitButton = $("#submit"),
            closeButton = $("#closeLargeModal");

    public RegistrationPage openPage() {
        open("https://demoqa.com/automation-practice-form");


        return this;
    }
    public RegistrationPage removeBannner() {
        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);

        return this;

    }

    public RegistrationPage setGender(String value) {
        setGender.$(byText(value)).click();

        return this;

    }

    public RegistrationPage userNumberInput(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage subjectsInput(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;

    }

    public RegistrationPage setHobbies(String value) {
        setHobbies.$(byText(value)).click();

        return this;

    }

    public RegistrationPage setPicture(String value) {
        setPicture.uploadFromClasspath(value);

        return this;

    }

    public RegistrationPage currentAddressInput(String value) {
        currentAddressInput.setValue(value);

        return this;

    }

    public RegistrationPage setState(String value) {
        $("#state").click();
        setState.$(byText(value)).click();

        return this;

    }

    public RegistrationPage setCity(String value) {
        $("#city").click();
        setCity.$(byText(value)).click();

        return this;

    }

    public RegistrationPage submitClick() {
        submitButton.click();

        return this;

    }

    public RegistrationPage verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();

        return this;
    }

    public RegistrationPage verifyResults(String key, String value) {
        registrationResultsModal.verifyResult(key, value);

        return this;
    }

    public RegistrationPage closeButtonClick() {
        closeButton.click();

        return this;

    }

}

