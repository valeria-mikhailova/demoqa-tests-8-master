package com.mikhailovavalery.pages.components;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.mikhailovavalery.tests.TestData.pathnamejpg;

public class FileUpploader {

    public void setFile(String pathname) {
    File file = $("#uploadPicture").uploadFile(new File(pathname));
    }
}
