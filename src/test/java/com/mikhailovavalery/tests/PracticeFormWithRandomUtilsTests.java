package com.mikhailovavalery.tests;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.mikhailovavalery.utils.RandomUtils.getRandomString;

public class PracticeFormWithRandomUtilsTests extends TestBase{

    String firstName = getRandomString(10),
            lastName = getRandomString(15);

    @Test
    void TestForm() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue("a.smith@gmail.com");
        $(".custom-control-label").click();
        $("#userNumber").setValue("2354567454");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("December");
        $(".react-datepicker__year-select").selectOptionByValue("1992");
        $(".react-datepicker__day--017").click();
        $("#subjectsContainer").find("input").setValue("Commerce").pressEnter();
        $("[for='hobbies-checkbox-2']").click();
        File file = $("#uploadPicture").uploadFile(new File("src/test/java/com/mikhailovavalery/tests/resources/PracticeForm.jpg"));
        $("#currentAddress").setValue("Blin Street");
        $("#state").find("input").setValue("NCR").pressEnter();
        $("#city").find("input").setValue("Gurgaon").pressEnter();
        $("#submit").scrollTo().click();
        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(firstName + " " + lastName),text("a.smith@gmail.com"), text("2354567454"), text("Commerce"),text("Reading"),text("PracticeForm.jpg"),text("Blin Street"),text("NCR"),text("Gurgaon")
        );
    }
}