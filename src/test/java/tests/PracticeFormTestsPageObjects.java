package tests;

import org.junit.jupiter.api.Test;
import pages.StudentRegistrationPage;
import pages.components.CalendarComponent;

public class PracticeFormTestsPageObjects extends TestBase {

    StudentRegistrationPage studentRegistration = new StudentRegistrationPage();
    CalendarComponent calendarComponent = new CalendarComponent();

    @Test
    void fillAllPracticeFormTest() {
        StudentRegistrationPage.openPage()
                .setFirstName("Alex")
                .setLastName(data.lastName)
                .setEmail(data.email)
                .setGender(data.gender)
                .setNumber(data.phone)
                .setDateOfBirth(data.birthDay, data.birthMonth, data.birthYear)
                .setSubjects(data.subjects)
                .setHobbies(data.hobbies)
                .setImagePath(data.image)
                .setAddress(data.address)
                .setState(data.state)
                .setCity(data.city)
                .submit();
    }
}
