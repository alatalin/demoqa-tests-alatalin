import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll () {
        Configuration.browser = "firefox";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }


    @Test
    void fillFormTest() {
        open("/text-box");
        $("[id=userName]").setValue("TestName");
        $("#userEmail").setValue("TestName@mail.com");
        $("#currentAddress").setValue("TestName_Adr");
        $("#permanentAddress").setValue("TestName_PermAdr");
        $("#submit").click();
        $("#output #name").shouldHave(text("TestName"));
        $("#output #email").shouldHave(text("TestName@mail.com"));
        $("#output #currentAddress").shouldHave(text("TestName_Adr"));
        $("#output #permanentAddress").shouldHave(text("TestName_PermAdr"));
    }
}