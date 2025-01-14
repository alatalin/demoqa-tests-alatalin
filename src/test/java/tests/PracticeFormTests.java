package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    @BeforeAll
    static void beforeAll () {
        Configuration.browser = "firefox";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillPracticeFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Latalin");
        $("#userEmail").setValue("AlexL@nomail.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9991234567");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("1990");
        $$(".react-datepicker__day").findBy(text("9")).click();
        $("#subjectsInput").setValue("compu");
        $$(".subjects-auto-complete__menu").find(Condition.text("Computer Science")).shouldBe(Condition.visible);
        $$(".subjects-auto-complete__menu").find(Condition.text("Computer Science")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("PNG_140Kb.png");
        $("#currentAddress").setValue("Russian Federation");
        $("#react-select-3-input").setValue("Rajasthan").pressEnter();
        $("#react-select-4-input").setValue("Jaipur").pressEnter();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table").shouldHave(text("Student Name")).shouldHave(text("Alex Latalin"));
        $(".table").shouldHave(text("Student Email")).shouldHave(text("AlexL@nomail.com"));
        $(".table").shouldHave(text("Gender")).shouldHave(text("Male"));
        $(".table").shouldHave(text("Mobile")).shouldHave(text("9991234567"));
        $(".table").shouldHave(text("Date of Birth")).shouldHave(text("09 April,1990"));
        $(".table").shouldHave(text("Subjects")).shouldHave(text("Computer Science"));
        $(".table").shouldHave(text("Hobbies")).shouldHave(text("Music"));
        $(".table").shouldHave(text("Picture")).shouldHave(text("PNG_140Kb.png"));
        $(".table").shouldHave(text("Address")).shouldHave(text("Russian Federation"));
        $(".table").shouldHave(text("State and City")).shouldHave(text("Rajasthan Jaipur"));
    }
}

