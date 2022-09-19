package com.demoqa;

import org.junit.jupiter.api.*;

public class ExampleJUnit5Test {

    @BeforeAll
    static void beforeAll() {
        System.out.println("this is the @Beforeall");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("this is the @Afterall");
    }

    @BeforeEach
    void setUp() {
        System.out.println("        BeforeEach");
    }

    @AfterEach
    void tearDown() {
        System.out.println("        AfterEach");
    }

    @Test
    void firstTest() {
        System.out.println("    This is test1");
    }

    @Test
    void secondTest() {
        System.out.println("    This is test2");
    }
}
