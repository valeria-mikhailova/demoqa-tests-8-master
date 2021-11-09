package com.mikhailovavalery.docs;

import org.junit.jupiter.api.*;

public class JUnit5Exampes {

    @BeforeAll
    static void beforeTest() {
        System.out.print("Before all test!\n\n");
    }

    @AfterAll
    static void afterAll() {
        System.out.print("After all test!\n");
    }

    @BeforeEach
    void BeforeTest() {
        System.out.print("Before test!\n\n");
    }

    @Test
    void firstTest() {
        System.out.print("I love you QA.QURU\n");
    }

    @Test
    void secondTest() {
        System.out.print("I love you QA.QURU, secondTest\n");
    }

    @AfterEach
    void afterTest() {
        System.out.print("After test!\n");
    }
}
