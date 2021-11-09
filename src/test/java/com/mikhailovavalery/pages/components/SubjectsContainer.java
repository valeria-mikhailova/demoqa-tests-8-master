package com.mikhailovavalery.pages.components;

import static com.codeborne.selenide.Selenide.$;

public class SubjectsContainer {

    public void setSubject(String subject) {
        $("#subjectsContainer").find("input").setValue(subject).pressEnter();
    }
}
