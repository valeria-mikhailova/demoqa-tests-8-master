package com.mikhailovavalery.tests;

import com.mikhailovavalery.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.mikhailovavalery.tests.TestData.*;

public class PracticeFormTestsWithPageObjectTestsHomeWork extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void TestForm() {
        registrationPage.openPage();
        registrationPage.typeFirstName(firstName)
                        .typeLastName(lastName)
                        .typeUserEmail(userEmail)
                        .typeUserAdress(userAdress);
        registrationPage.setSexMale();
        registrationPage.typeUserNumber(UserNumber);
        registrationPage.calendar.setDate("17", "December", "1992");
        registrationPage.subject.setSubject("Commerce");
        registrationPage.setHobbyReading();
        registrationPage.pic.setFile(pathnamejpg);
        registrationPage.findState()
                        .findCity();
        registrationPage.clickSubmit();
        registrationPage.shouldHaveText()
                        .checkResultsValue("Student Name", firstName + " " + lastName)
                .checkResultsValue("Student Email", userEmail)
                .checkResultsValue("Gender", "Male")
                .checkResultsValue("Mobile", UserNumber)
                .checkResultsValue("Date of Birth", "17 December,1992")
                .checkResultsValue("Subjects", "Commerce")
                .checkResultsValue("Hobbies", "Reading")
                .checkResultsValue("Picture", "PracticeForm.jpg")
                .checkResultsValue("Address", userAdress)
                .checkResultsValue("State and City",stateNCR + " " + cityDelhi );
    }
}
//     Пример, как писать более красиво. Вместо длинных строчек с плюсами (см строчку предыдущую)
//     String bigtext = "apple %s banana %s ananas"; // на места %s встанут переменные b и c
//     String b = "and";
//     String c = "not";
//     System.out.print(String.format(bigtext, b, c));