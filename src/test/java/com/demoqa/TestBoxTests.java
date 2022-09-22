package com.demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.timeout;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestBoxTests  {

    @BeforeAll
    static void configire() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
       //  Configuration.browser ="safari";

    }

    @Test
    void fillFormTest() {
        open("/text-box");
        $ ("#userName").setValue("Alexey Nifontov");
     //   $ ("[id=userName]").setValue("Alexey Nifontov");
        $("#userEmail").setValue("mail@testme.com");
        $("#currentAddress").setValue("4781 S Citation dr");
        $("#permanentAddress").setValue("5681 Yamato rd");
        $("#submit").click();
        $("#output #name").shouldHave(text("Alexey"));
        //$("#output").$("#name").shouldHave(Condition.text("Alexey"));
        $("#output #email").shouldHave(text("mail@testme.com"));
        $("#output #currentAddress").shouldHave(text("4781 S Citation dr"));
        $("#output #permanentAddress").shouldHave(text("5681 Yamato rd"));




    }
}
