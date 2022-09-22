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
        String name = "John Joe";
        String mail = "JohnDoe@mail.com";
        String address = "4781 S Citation dr";
        String address2 = "5681 Yamato rd";

        open("/text-box");
        $ ("#userName").setValue(name);
     //   $ ("[id=userName]").setValue("Alexey Nifontov");
        $("#userEmail").setValue(mail);
        $("#currentAddress").setValue(address);
        $("#permanentAddress").setValue(address2);
        $("#submit").click();
        $("#output #name").shouldHave(text(name));
        //$("#output").$("#name").shouldHave(Condition.text("Alexey"));
        $("#output #email").shouldHave(text(mail));
        $("#output #currentAddress").shouldHave(text(address));
        $("#output #permanentAddress").shouldHave(text(address2));




    }
}
