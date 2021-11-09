package com.mikhailovavalery.pages;

import com.codeborne.selenide.SelenideElement;
import com.mikhailovavalery.pages.components.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.mikhailovavalery.tests.TestData.*;

public class RegistrationPage {

    private final String FORM_TITLE = "Student Registration Form";

    private SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            userAdressInput =  $("#currentAddress"),
            stateList = $("#state"),
            cityList = $("#city"),
            buttonSubmit = $("#submit"),
            titleText = $(".modal-title"),
            male = $(".custom-control-label"),
            reading = $("[for='hobbies-checkbox-2']");

    public CalendarComponent calendar = new CalendarComponent();
    public SubjectsContainer subject = new SubjectsContainer();
    public FileUpploader pic = new FileUpploader();

    public RegistrationPage setSexMale() {
        male.click();
        return this;
    }

    public void setHobbyReading() {
        reading.click();
    }

    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));
    }

    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage typeUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage checkResultsValue(String key, String value) {
        $x("//td[text()='" + key + "']").parent().shouldHave(text(value));
        return this;
    }

    public RegistrationPage typeUserAdress(String value) {
        userAdressInput.setValue(value);
        return this;
    }

    public RegistrationPage findState() {
        stateList.find("input").setValue(stateNCR).pressEnter();
        return this;
    }

    public RegistrationPage findCity() {
        cityList.find("input").setValue(cityDelhi).pressEnter();
        return this;
    }

    public void clickSubmit() {
        buttonSubmit.scrollTo().click();
    }

    public RegistrationPage shouldHaveText() {
        titleText.shouldHave(text("Thanks for submitting the form"));
        return this;
    }
}
