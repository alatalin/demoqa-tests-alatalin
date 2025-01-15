package tests;

import org.junit.jupiter.api.Test;
import pages.StudentRegistrationPage;

public class PracticeFormTestsPageObject extends TestBase {

    private final StudentRegistrationPage studentRegistrationPage = new StudentRegistrationPage();

    @Test
    public void succesfullFillAllPracticeFormTest() {
        studentRegistrationPage.openPage()
                .setFirstName("Alex")
                .setLastName("Latalin")
                .setUserEmail("AlexL@nomail.com")
                .setGenderWrapper("Male")
                .setUserNumber("9991234567")
                .setDateOfBirth("9", "April", "1990")
                .setSubjects("Computer Science")
                .setHobbies("Music")
                .imageUpload("PNG_140Kb.png")
                .setCurrentAddress("Russian Federation")
                .setUserState("Rajasthan")
                .setUserCity("Jaipur")
                .submitButtonClick()

                .checkRegistrationResultMessage("Thanks for submitting the form")
                .checkRegistrationResultTable("Student Name","Alex Latalin")
                .checkRegistrationResultTable("Student Email","AlexL@nomail.com")
                .checkRegistrationResultTable("Gender","Male")
                .checkRegistrationResultTable("Mobile","9991234567")
                .checkRegistrationResultTable("Date of Birth","09 April,1990")
                .checkRegistrationResultTable("Subjects","Computer Science")
                .checkRegistrationResultTable("Hobbies","Music")
                .checkRegistrationResultTable("Picture","PNG_140Kb.png")
                .checkRegistrationResultTable("Address","Russian Federation")
                .checkRegistrationResultTable("State and City","Rajasthan Jaipur");
    }

    @Test
    public void succesfullMimimumDataPracticeFormTest() {
        studentRegistrationPage.openPage()
                .setFirstName("Alex")
                .setLastName("Latalin")
                .setGenderWrapper("Male")
                .setUserNumber("9991234567")
                .submitButtonClick()

                .checkRegistrationResultMessage("Thanks for submitting the form")
                .checkRegistrationResultTable("Student Name","Alex Latalin")
                .checkRegistrationResultTable("Gender","Male")
                .checkRegistrationResultTable("Mobile","9991234567");
    }
}
