package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class LessonTest {

    @DisplayName("Set configurations before all tests")
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @ValueSource(strings = {
            "Anuar",
            "Yernar"
    })
    @ParameterizedTest(name = "{0}")
    void bccTest(String strings) {
        Selenide.open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $("#firstName").setValue(strings);
        $("#lastName").setValue("Abitay");
        $("#userEmail").setValue("anuarabitay@gmail.com");
        $(byText("Male")).click();
        $("#userNumber").setValue("7473050157");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("October");
        $(".react-datepicker__year-select").selectOption("1999");
        $("[aria-label$='October 21st, 1999']").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $(byText("Sports")).click();
        $(byText("Music")).click();
        $("#currentAddress").setValue("8 micro-district");
        $("#state").scrollIntoView(true);
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#city").click();
        $("#submit").pressEnter();
        $(".table-responsive").shouldHave(text(strings + " Abitay"),
                text("anuarabitay@gmail.com"),
                text("Male"),
                text("7473050157"),
                text("21 October,1999"),
                text("Math"),
                text("Sports, Music"),
                text("8 micro-district"),
                text("NCR Delhi"));
        $("#closeLargeModal").click();
    }

    @CsvSource(value = {
            "Anuar, Abitay",
            "Yernar, Abitayev"
    })
    @ParameterizedTest(name = "{0} {1}")
    void secondTest(String name, String lastName) {
        Selenide.open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $("#firstName").setValue(name);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue("anuarabitay@gmail.com");
        $(byText("Male")).click();
        $("#userNumber").setValue("7473050157");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("October");
        $(".react-datepicker__year-select").selectOption("1999");
        $("[aria-label$='October 21st, 1999']").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $(byText("Sports")).click();
        $(byText("Music")).click();
        $("#currentAddress").setValue("8 micro-district");
        $("#state").scrollIntoView(true);
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#city").click();
        $("#submit").pressEnter();
        $(".table-responsive").shouldHave(text(name + " " + lastName),
                text("anuarabitay@gmail.com"),
                text("Male"),
                text("7473050157"),
                text("21 October,1999"),
                text("Math"),
                text("Sports, Music"),
                text("8 micro-district"),
                text("NCR Delhi"));
        $("#closeLargeModal").click();
    }
}


