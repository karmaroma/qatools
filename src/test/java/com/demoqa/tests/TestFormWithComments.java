package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestFormWithComments {

    String lastname = "Doe";
    String mail = "John_Doe@gmail.com";
    String phone = "2128506100";
    String address = "4781 Yamato rd. Apt 206";

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void configire() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";

    }

    @Test
    void testname() {




        $("#lastName").setValue(lastname);
        $("#userEmail").setValue(mail);
        $("#genterWrapper").$(byText("Other")).click();
        $("#userNumber").setValue(phone);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__year-select").selectOption("1980");
        $(".react-datepicker__day--030:not(react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("#genterWrapper").$(byText("Other")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("img/ExamplePhoto.jpg");
        $("#currentAddress").setValue(address);
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();


        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        // $(".table-responsive table").shouldHave(name), (text(lastname), (text(mail), (text(phone));




    } @Test
    void fillFormWithMinimumDataTest() {

        String name = "John";
        String lastname = "Doe";
        String mail = "John_Doe@gmail.com";
        String phone = "2128506100";
        String address = "4781 Yamato rd. Apt 206";

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue(name);
        $("#lastName").setValue(lastname);
        $("#userEmail").setValue(mail);
        $("#genterWrapper").$(byText("Other")).click();
        $("#userNumber").setValue(phone);
        $("#submit").click();


        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive table").shouldHave(text(name), text(lastname), text(mail), text(phone));
        $(".table-responsive table").shouldHave(text(name), text(lastname), text(mail), text(phone));




    }
 }
