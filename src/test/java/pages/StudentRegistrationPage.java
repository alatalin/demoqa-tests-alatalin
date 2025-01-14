package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class StudentRegistrationPage {

    public SelenideElement firstNameInput = $("#firstName"),
    lastNameInput = $("#lastName"),
    userEmailInput = $("#userEmail"),
    genderWrapperInput = $("#genterWrapper"),
    userNumberInput = $("#userNumber"),
    dateOfBirthInput = $("#dateOfBirthInput"),
    subjectsInput = $("#subjectsInput"),
    hobbies = $("#hobbiesWrapper"),
    imageUpload = $("#uploadPicture"),
    currentAdressInput = $("#currentAddress"),


    public CalendarComponent calendarComponent = new CalendarComponent();

    public void openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
    }

    public void setFirstName (String value) {
        firstNameInput.setValue(value);
    }

    public void setLastName (String value) {
        lastNameInput.setValue(value);
    }

    public void setUserEmailInput (String value) {
        userEmailInput.setValue(value);
    }

    public void setGenderWrapperInput(String value) {
        genderWrapperInput.$(byText(value)).click();
    }

    public void setUserNumber (String value) {
        userNumberInput.setValue(value);
    }

    public void setDateOfBirth (String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day,month,year);
    }

    public void setSubjectsInput (String value) {
        subjectsInput.setValue(value).pressTab();
    }

    public void setHobbies (String value) {
        hobbies.$(byText(value)).click();
    }

    public void imageUpload (String value) {
        imageUpload.uploadFromClasspath(value);
    }

    public void setCurrentAdress (String value) {
        currentAdressInput.setValue(value);
    }


}