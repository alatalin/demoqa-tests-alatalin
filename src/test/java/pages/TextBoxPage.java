package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextBoxPage {
    private final SelenideElement fullNameInput = $("#userName"),
    emailInput = $("#userEmail"),
    currentAddressInput = $("#currentAddress"),
    permanentAddressInput = $("#permanentAddress"),
    submitBtn = $("#submit"),
    checkResultField = $("#output");

    public TextBoxPage openPage() {
        open("/text-box");
        $(".text-center").shouldHave(text("Text Box"));
        return this;
    }

    public TextBoxPage disableBanners() {
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public TextBoxPage setFullName (String value) {
        fullNameInput.setValue(value);
        return this;
    }

    public TextBoxPage setUserEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public TextBoxPage setCurrentAddress (String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage setPermanentAddress (String value) {
        permanentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage submitBtnClick() {
        submitBtn.click();
        return this;
    }

    public TextBoxPage checkResult (String key, String value) {
        checkResultField.shouldHave(text(key)).shouldHave(text(value));
        return this;
    }
}
