package com.mikhailovavalery.tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormWithFackerTestsHomeWork extends TestBase{

    Faker faker = new Faker();
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            currentAddress = faker.lebowski().quote(),
            userNumder = faker.phoneNumber().subscriberNumber(10);

    @Test
    void TestForm() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $(".custom-control-label").click();
        $("#userNumber").setValue(userNumder);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("December");
        $(".react-datepicker__year-select").selectOptionByValue("1992");
        $(".react-datepicker__day--017").click();
        $("#subjectsContainer").find("input").setValue("Commerce").pressEnter();
        $("[for='hobbies-checkbox-2']").click();
        File file = $("#uploadPicture").uploadFile(new File("src/test/java/com/mikhailovavalery/tests/resources/PracticeForm.jpg"));
        $("#currentAddress").setValue(currentAddress);
        $("#state").find("input").setValue("NCR").pressEnter();
        $("#city").find("input").setValue("Gurgaon").pressEnter();
        $("#submit").scrollTo().click();
        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(firstName + " " + lastName),text(userEmail), text(userNumder),
                text("Commerce"),text("Reading"),text("PracticeForm.jpg"),text(currentAddress),text("NCR"),text("Gurgaon")
        );
    }
}