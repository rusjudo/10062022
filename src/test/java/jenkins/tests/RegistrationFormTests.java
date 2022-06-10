package jenkins.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


@Tag("demoqa")
public class RegistrationFormTests extends TestBase{



    @Test
    @DisplayName("Successful fill registration test")
    void fillFormTest() {
        step("Open Reg Form", () -> {
                    open("/automation-practice-form");
                    $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
                    executeJavaScript("$('footer').remove()");
                    executeJavaScript("$('#fixedban').remove()");
                });
        step("Fill Reg Form", () -> {
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Egorov");
        $("#userEmail").setValue("alex@egorov.com");
        $("#genterWrapper").$(byText("Other")).click();
        $("#userNumber").setValue("1231231230");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2008");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        //$("#uploadPicture").uploadFile(new File("src/test/resources/img/1.png"));
        $("#currentAddress").setValue("Some street 1");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();
        });
        step("Check Reg Form", () -> {
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Alex Egorov"), text("alex@egorov.com"), text("Other"));
        });
    }

}
