package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTestsPageObject extends TestBase {

    private final TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    public void succesfullFillAllTextBoxTest(){
        textBoxPage.openPage()
                .disableBanners()
                .setFullName("Alex Latalin")
                .setUserEmail("AlexL@nomail.com")
                .setCurrentAddress("Russian Federation")
                .setPermanentAddress("Japan")
                .submitBtnClick()

                .checkResult("Name","Alex Latalin")
                .checkResult("Email","AlexL@nomail.com")
                .checkResult("Current Address","Russian Federation")
                .checkResult("Permananet Address","Japan");
    }
}
