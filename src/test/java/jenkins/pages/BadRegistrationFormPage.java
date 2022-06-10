package jenkins.pages;

import static com.codeborne.selenide.Selenide.$;

public class BadRegistrationFormPage {
    // locators
    String firstNameInput = "#firstName";

    // actions
    public BadRegistrationFormPage setFirstName(String value) {
        $(firstNameInput).setValue(value);

        return this;
    }
}
