package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
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

    @Step("Открыть главную страницу")
    public RegistrationPage openPage() {
        open("https://demoqa.com/automation-practice-form");


        return this;
    }

    @Step("Убираем баннер")
    public RegistrationPage removeBannner() {
        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");

        return this;
    }
    @Step("Ввести имя пользователя")
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }
    @Step("Ввести имя пользователя")
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }
    @Step("Ввести email")
    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);

        return this;

    }
    @Step("Выбрать пол")
    public RegistrationPage setGender(String value) {
        setGender.$(byText(value)).click();

        return this;

    }
    @Step("Ввести номер телефона")
    public RegistrationPage userNumberInput(String value) {
        userNumberInput.setValue(value);

        return this;
    }
    @Step("Выбрать дату рождения")
    public RegistrationPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);

        return this;
    }
    @Step("Ввести предмет")
    public RegistrationPage subjectsInput(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;

    }
    @Step("Выбрать хобби")
    public RegistrationPage setHobbies(String value) {
        setHobbies.$(byText(value)).click();

        return this;

    }
    @Step("Загрузить картинку")
    public RegistrationPage setPicture(String value) {
        setPicture.uploadFromClasspath(value);

        return this;

    }
    @Step("Ввести текущий адресс")
    public RegistrationPage currentAddressInput(String value) {
        currentAddressInput.setValue(value);

        return this;

    }
    @Step("Выбрать штат")
    public RegistrationPage setState(String value) {
        $("#state").click();
        setState.$(byText(value)).click();

        return this;

    }
    @Step("Выбрать город")
    public RegistrationPage setCity(String value) {
        $("#city").click();
        setCity.$(byText(value)).click();

        return this;

    }
    @Step("Нажать подтвердить")
    public RegistrationPage submitClick() {
        submitButton.click();

        return this;

    }
    @Step("Проверить что все значения в таблице совпадают")
        public RegistrationPage verifyResultsModalAppears () {
            registrationResultsModal.verifyModalAppears();

            return this;
        }

        public RegistrationPage verifyResults (String key, String value){
            registrationResultsModal.verifyResult(key, value);

            return this;
        }
    @Step("Закрыть форму")
    public RegistrationPage closeButtonClick() {
        closeButton.click();

        return this;

    }

}

