package com.mikhailovavalery.docs;

import static com.codeborne.selenide.Selenide.$;
import static com.mikhailovavalery.utils.RandomUtils.*;
import static com.mikhailovavalery.utils.RandomUtils.getRandomPhone;

public class RandomExamples {
    public static void main(String[] args) {
        System.out.println(getRandomString(32));
 //       $("#id").setValue(getRandomString(32));

        String randomMessage = getRandomMessage(31, 42);
        System.out.println(randomMessage);

//        int randomInt = getRandomInt(int 223333, int 100000000);
//        System.out.println(randomInt + "");

        String randomPhone = getRandomPhone();
        System.out.println(randomPhone);

        String randomPhoneWithPrefix = getRandomPhone("+7");
        System.out.println(randomPhoneWithPrefix);

        String difficultRandomPhoneWithPrefix = getDifficultRandomPhone("+8");
        System.out.println(difficultRandomPhoneWithPrefix);

        String randomEmail = getRandomEmail();
        System.out.println(randomEmail);




    }
}
