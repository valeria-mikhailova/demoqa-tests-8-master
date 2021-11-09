package com.mikhailovavalery.tests;

import com.mikhailovavalery.pages.RegistrationPage;
import com.mikhailovavalery.tests.TestBase;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.mikhailovavalery.tests.TestData.firstName;
import static com.mikhailovavalery.tests.TestData.lastName;

public class PracticeFormTestsWithPageObjectTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void TestForm() {
        registrationPage.openPage();

        registrationPage.typeFirstName(firstName)
                        .typeLastName(lastName);

        $("#userEmail").setValue("a.smith@gmail.com");
        $(".custom-control-label").click();
        $("#userNumber").setValue("2354567454");

        registrationPage.calendar.setDate("17", "December", "1992");

        $("#subjectsContainer").find("input").setValue("Commerce").pressEnter();
        $("[for='hobbies-checkbox-2']").click();
        File file = $("#uploadPicture").uploadFile(new File("src/test/java/com/mikhailovavalery/tests/resources/PracticeForm.jpg"));
        $("#currentAddress").setValue("Blin Street");
        $("#state").find("input").setValue("NCR").pressEnter();
        $("#city").find("input").setValue("Gurgaon").pressEnter();
        $("#submit").scrollTo().click();
        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        registrationPage.checkResultsValue("Student Name", firstName + " " + lastName );


//     Пример, как писать более красиво. Вместо длинных строчек с плюсами (см строчку предыдущую)
//     String bigtext = "apple %s banana %s ananas"; // на места %s встанут переменные b и c
//     String b = "and";
//     String c = "not";
//     System.out.print(String.format(bigtext, b, c));

    }
}